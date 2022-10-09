package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comprador")
public class Comprador extends Persistente {

  @OneToOne(cascade = CascadeType.PERSIST)
  private CarritoDeCompra carritoDeCompra;

  @OneToMany
  private List<Compra> compras;

  public Comprador() {}

  public Comprador(CarritoDeCompra carritoDeCompra) {
    this.compras = new ArrayList<>();
    this.carritoDeCompra = carritoDeCompra;
  }

  public void agregarProducto(Item item) {

    this.carritoDeCompra.agregarProducto(item);
  }

}
