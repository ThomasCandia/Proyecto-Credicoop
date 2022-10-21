package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comprador")
public class Comprador extends Persistente {

  @ManyToMany
  private List<CarritoDeCompra> carritosDeCompra;


  public Comprador(CarritoDeCompra carritoDeCompra) {
    this.compras = new ArrayList<>();
    this.carritoDeCompra = carritoDeCompra;
  }

  // TODO agregar item iría en el comprador tambien?
  /*public void agregarItem(Item item) {

    this.carritoDeCompra.agregarProducto(item);
  }

}
