package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comprador")
@Getter
public class Comprador extends Persistente {

  @OneToMany
  @JoinColumn(name = "Comprador_id", referencedColumnName = "id")
  private List<CarritoDeCompra> carritosDeCompra;


  public Comprador() {
    this.carritosDeCompra = new ArrayList<>();
  }


  public CarritoDeCompra getCarritoActual() {
    int tamanio = this.carritosDeCompra.size();
    return this.carritosDeCompra.get(tamanio-1);
  }

}
