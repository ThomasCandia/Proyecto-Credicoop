package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.Vendedor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra extends Persistente {

  //ATRIBUTOS

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Item> itemsAComprar;


  //CONSTRUCTORES

  public CarritoDeCompra() {
    this.itemsAComprar = new ArrayList<>();
  }

  //METODOS


  public void agregarProducto(Item item) throws Exception {

    //SI ESTA VACIO SE AGREGA EL ITEM SIN VERIFICAR EL VENDEDOR
    if (itemsAComprar.isEmpty()) {
      this.itemsAComprar.add(item);
    }
    // VALIDAMOS SI EL VENDEDOR DEL ITEM A AGREGAR ES EL MISMO DEL ULTIMO ITEM AGREGADO
    else if(this.getUltimoItem().getProductoPersonalizado().getVendedor() == item.getProductoPersonalizado().getVendedor()){
      this.itemsAComprar.add(item);
      //TODO heredar excepciones para que queden nombres lindos
    } else throw new Exception("El item ingresado no es del mismo vendedor");
  }


  public void eliminarProducto(Integer itemID) throws Exception {
    //BUSCAMOS EL ITEM POR ID
    Optional<Item> itemABorrar = this.itemsAComprar.stream().filter(item -> item.getId().equals(itemID)).findFirst();

    //SI LO ENCONTRAMOS LO BORRAMOS Y SINO TIRAMOS EXCEPCION
    if (itemABorrar.isPresent()) {
      this.itemsAComprar.remove(itemABorrar.get());
    }
    else {
      throw new Exception("El item no está en el carrito");
    }
  }

  public Double calcularTotal(){
    return this.itemsAComprar.stream().mapToDouble(Item::calcularPrecio).sum();
  }

  public Item getUltimoItem(){
    return this.itemsAComprar.get(itemsAComprar.size()-1);
  }

  public Vendedor getVendedorElegido()
  {
    return this.getUltimoItem().getProductoPersonalizado().getVendedor();
  }
}
