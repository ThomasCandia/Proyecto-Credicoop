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


  public Comprador() {
    this.carritosDeCompra = new ArrayList<>();
  }
  
  public CarritoDeCompra getCarritoActual() {
    int tamanio = this.carritosDeCompra.size();
    return this.carritosDeCompra.get(tamanio-1);
  }

  // TODO agregar item iría en el comprador tambien?
  /*public void agregarItem(Item item) {



  }*/

}
