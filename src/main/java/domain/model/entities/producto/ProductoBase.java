package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Producto_Base")
@Setter @Getter
public class ProductoBase extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "Precio_Base")
  private Double precioBase;

  @Column(name = "Descripcion")
  private String descripcion;

  @Column(name = "Tiempo_Fabricacion")
  private String tiempoFabricacion;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "Producto_Base_id", referencedColumnName = "id")
  private List<Area> areas;

 public ProductoBase() {}

 public ProductoBase(String nombre, Double precioBase, String descripcion, String tiempoFabricacion) {
 this.areas = new ArrayList<>();
 this.nombre = nombre;
 this.precioBase = precioBase;
 this.descripcion = descripcion;
 this.tiempoFabricacion = tiempoFabricacion;
}
  public void agregarArea(Area area){
   this.areas.add(area);
  }

}
