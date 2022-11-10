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
  //TODO CAMBIAR
  private List<MetodoDePago> metodosDePagos;

  @OneToMany
  private List<ProductoPersonalizado> productosPersonalizados;

  public Vendedor() {
    this.metodosDePagos = new ArrayList<>();
    this.productosPersonalizados = new ArrayList<>();
  }

  public Vendedor(String nombre, String apellido, Tienda tienda, List<MetodoDePago> metodosDePagos) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.tienda = tienda;
    this.metodosDePagos = metodosDePagos;
    this.productosPersonalizados = new ArrayList<>();
  }


}
