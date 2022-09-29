package domain.model.entities;

import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Publicacion")
@Setter @Getter
public class Publicacion extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @OneToOne
  private ProductoPersonalizado productoPublicado;

  @OneToMany
  @JoinColumn(name = "Publicacion_id", referencedColumnName = "id")
  private List<RegistroEstado> registrosEstados;

  public Publicacion()
  {
    this.registrosEstados = new ArrayList<>();
  }

  public Publicacion(String nombre,ProductoPersonalizado productoPublicado)
  {
    this.nombre = nombre;
    this.productoPublicado = productoPublicado;
    this.registrosEstados = new ArrayList<>();
  }
}
