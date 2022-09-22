package domain.models.entities.producto;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Producto_Base")
@Setter
@Getter
public class ProductoBase extends Persistente {
  @Column(name = "nombre")
  private String nombre;

  @Column(name = "Precio_Base")
  private Double precioBase;
  @Column(name = "Descripcion")
  private String descripcion;
@Column(name = "Tiempo_Fabricacion")
  private String tiempoFabricacion;

  private List<Area> areas;

 public ProductoBase()
 {
   this.areas = new ArrayList<>();
 }

public ProductoBase(String nombre, Double precioBase, String descripcion, String tiempoFabricacion)
{
 this.areas = new ArrayList<>();
 this.nombre = nombre;
 this.descripcion = descripcion;
 this.tiempoFabricacion = tiempoFabricacion;
}
}
