package domain.model.entities.producto;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.Vendedor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Producto_Personalizado")
@Setter @Getter
public class ProductoPersonalizado extends Persistente {

  //@NotNull
  @ManyToOne
  private ProductoBase productoBase;

 @OneToMany
 @JoinColumn(name = "Producto_Personalizado_id", referencedColumnName = "id")
 @RestResource(exported = false)
  private List<Personalizacion> personalizaciones;

 @NotNull
 @ManyToOne
 @JoinColumn(name = "vendedor_id")
 private Vendedor vendedor;

  public ProductoPersonalizado() {}

  public ProductoPersonalizado(ProductoBase productoBase, Vendedor vendedor) {
    this.productoBase = productoBase;
    this.vendedor = vendedor;
    this.personalizaciones = new ArrayList<>();
  }

  public Double calcularPrecioFinal(){
    return productoBase.getPrecioBase() + this.precioDeLasPersonalizaciones();
  }

  public Double precioDeLasPersonalizaciones() {
      return this.personalizaciones.stream().mapToDouble(p -> p.getPrecio()).sum();
  }

  public void agregarPersonalizacion(Personalizacion personalizacion) {
    this.personalizaciones.add(personalizacion);
  }

}
