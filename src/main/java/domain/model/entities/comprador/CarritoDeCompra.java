package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.Vendedor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Entity
@Table(name = "CarritoDeCompra")
@Getter@Setter
public class CarritoDeCompra extends Persistente{


  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
  private List<Item> itemsAComprar;

  public CarritoDeCompra() {
    this.itemsAComprar = new ArrayList<>();
  }

  public void agregarProducto(Item item) throws Exception {

    //SI ESTA VACIO SE AGREGA EL ITEM SIN VERIFICAR EL VENDEDOR
    if (itemsAComprar.isEmpty()) {
      this.itemsAComprar.add(item);
    }
    // VALIDAMOS SI EL VENDEDOR DEL ITEM A AGREGAR ES EL MISMO DEL ULTIMO ITEM AGREGADO
    else if( this.ultimoItem().getProductoPersonalizado().getVendedor().equals(item.getProductoPersonalizado().getVendedor()) ){
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

  public Item ultimoItem() throws Exception {
    if(this.itemsAComprar.size() <=0){
      throw new Exception("El carrito está vacio!"); //TODO mejorar excepcion
    }
      return this.itemsAComprar.get(itemsAComprar.size()-1);



  }

  public Vendedor vendedorElegido() throws Exception {
    return this.ultimoItem().getProductoPersonalizado().getVendedor();
  }
}
