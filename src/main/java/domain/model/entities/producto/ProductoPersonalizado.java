package domain.model.entities.producto;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.Vendedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Producto_Personalizado")
@Setter @Getter
public class ProductoPersonalizado extends Persistente {

  @ManyToOne
  private ProductoBase productoBase;

 @OneToMany
 @JoinColumn(name = "Producto_Personalizado_id", referencedColumnName = "id")
  private List<Personalizacion> personalizaciones;

 @ManyToOne
 @JoinColumn(name = "vendedor_id")
 private Vendedor vendedor;


  public Double calcularPrecioFinal(){
    return productoBase.getPrecioBase() + this.precioDeLasPersonalizaciones();
  }

  public Double precioDeLasPersonalizaciones(){
      return this.personalizaciones.stream().mapToDouble(p -> p.getPrecio()).sum();
  }
}
