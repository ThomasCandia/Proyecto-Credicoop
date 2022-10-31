package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

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
  @JoinColumn(name = "ProductoBase_id", referencedColumnName = "id")
  private List<AreaPorProductoBase> areas;

 public ProductoBase() {}

 public ProductoBase(String nombre, Double precioBase, String descripcion, String tiempoFabricacion, List<AreaPorProductoBase> areas) {
 this.nombre = nombre;
 this.precioBase = precioBase;
 this.descripcion = descripcion;
 this.tiempoFabricacion = tiempoFabricacion;
 this.areas = areas;
}
  public void agregarArea(Area area){
   this.areas.add(area);
  }

  public boolean validarPersonalizacion(Personalizacion personalizacion)
  {
    return this.areas.stream().anyMatch(area -> area.validarPersonalizacion(personalizacion));
  }
}


