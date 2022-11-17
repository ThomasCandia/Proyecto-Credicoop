package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comprador")
@Getter@Setter
public class Comprador extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "Comprador_id", referencedColumnName = "id")
  private List<CarritoDeCompra> carritosDeCompra;


  public Comprador() {
    this.carritosDeCompra = new ArrayList<>();
    this.carritosDeCompra.add(new CarritoDeCompra());
  }


  public CarritoDeCompra getCarritoActual() {
    int tamanio = this.carritosDeCompra.size();
    return this.carritosDeCompra.get(tamanio-1);
  }

}
