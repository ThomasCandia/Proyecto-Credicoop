package domain.model.entities.comprador;

import domain.model.entities.Persistente;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra extends Persistente {

  //ATRIBUTOS

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Item> itemsAComprar;

  public CarritoDeCompra() {
    this.itemsAComprar = new ArrayList<>();
  }

  public void agregarProducto(Item item){
    //TODO hacer las validaciones del mismo vendedor acá
    this.itemsAComprar.add(item);
  }

  public void eliminarProducto(Item item){
    this.itemsAComprar.remove(item);
  }

  public Double calcularTotal(){
    return this.itemsAComprar.stream().mapToDouble(Item::calcularPrecio).sum();
  }

}
