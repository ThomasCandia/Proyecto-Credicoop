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

  private Boolean estaPublicado;

  //@NotNull
  @ManyToOne
  private ProductoBase productoBase;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "Producto_Personalizado_id", referencedColumnName = "id")
  private List<Personalizacion> personalizaciones;

  @ManyToOne
  @JoinColumn(name = "vendedor_id")
  private Vendedor vendedor;

  public ProductoPersonalizado() {
    this.personalizaciones = new ArrayList<>();
  }

  public ProductoPersonalizado(ProductoBase productoBase, Vendedor vendedor,List<Personalizacion>personalizaciones) {
    this.productoBase = productoBase;
    this.vendedor = vendedor;
    this.personalizaciones = personalizaciones;
    this.estaPublicado = false;
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
