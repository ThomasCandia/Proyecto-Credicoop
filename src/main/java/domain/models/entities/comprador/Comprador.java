package domain.models.entities.comprador;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Comprador")
public class Comprador extends Persistente {

  public CarritoDeCompra carritoDeCompra;

  public Comprador() {
  }
  public Comprador(CarritoDeCompra carritoDeCompra) {
    this.carritoDeCompra = carritoDeCompra;
  }

}
