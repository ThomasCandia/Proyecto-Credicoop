package domain.model.entities;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.ProductoBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter @Getter
public class ClasePruebaError extends Persistente{

  @OneToOne
  private ProductoBase productoBase;

  @OneToOne
  private Area area;


}
