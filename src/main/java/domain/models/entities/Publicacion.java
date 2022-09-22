package domain.models.entities;

import domain.models.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Publicacion")
@Setter @Getter
public class Publicacion extends Persistente {
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "Producto_Publicado")
  private ProductoPersonalizado productoPublicado;

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
