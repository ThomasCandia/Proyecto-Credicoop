package domain.model.entities.comprador;

import domain.model.entities.Persistente;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comprador")
public class Comprador extends Persistente {

  @OneToOne
  public CarritoDeCompra carritoDeCompra;

  public Comprador() {
  }
  public Comprador(CarritoDeCompra carritoDeCompra) {
    this.carritoDeCompra = carritoDeCompra;
  }

}
