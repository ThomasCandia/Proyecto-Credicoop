package domain.model.entities.comprador;

import domain.model.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "Comprador")
public class Comprador extends Persistente {

  @OneToOne(cascade = CascadeType.PERSIST)
  public CarritoDeCompra carritoDeCompra;

  public Comprador() {
  }
  public Comprador(CarritoDeCompra carritoDeCompra) {
    this.carritoDeCompra = carritoDeCompra;
  }

}
