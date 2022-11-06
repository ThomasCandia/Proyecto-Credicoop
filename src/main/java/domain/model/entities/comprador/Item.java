package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@Getter@Setter
public class Item extends Persistente {

  @Column(name = "cantidad")
  private int cantidad;

  @ManyToOne
  @JoinColumn(name = "producto_personalizado_id", referencedColumnName = "id")
  private ProductoPersonalizado productoPersonalizado;

  public Item() {}

  public Item(int cantidad, ProductoPersonalizado productoPersonalizado) {
    this.cantidad = cantidad;
    this.productoPersonalizado = productoPersonalizado;
  }

  public Double calcularPrecio(){
    return this.productoPersonalizado.calcularPrecioFinal() * this.cantidad;
  }
}
