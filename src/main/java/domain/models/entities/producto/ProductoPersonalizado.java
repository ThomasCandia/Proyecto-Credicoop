package domain.models.entities.producto;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Producto_Personalizado")
@Setter @Getter
public class ProductoPersonalizado extends Persistente {

  @ManyToOne
  private ProductoBase productoBase;
  private List<Personalizacion> personalizaciones;


  public Double calcularPrecioFinal(){
    return productoBase.getPrecioBase() + this.precioDeLasPersonalizaciones();
  }

  public Double precioDeLasPersonalizaciones(){
  return 0.0;
  }
}
