package domain.model.entities.vendedor;

import domain.model.entities.publicacion.Tienda;
import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vendedor")
@Setter @Getter
public class Vendedor extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private Tienda tienda;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private List<MetodoDePago> metodoDePagos;

  @OneToMany
  private List<ProductoPersonalizado> productosPersonalizados;

  public Vendedor() {}

  public Vendedor(Tienda tienda) {
    this.metodoDePagos = new ArrayList<>();
    this.productosPersonalizados = new ArrayList<>();
    this.tienda = tienda;
  }

}
