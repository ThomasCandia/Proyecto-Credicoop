package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Area")
@Setter @Getter
public class Area extends Persistente {

  @Column(name = "Lugar_Personalizable")
  private String lugarPersonalizable;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @RestResource(exported = false)
  private List<TipoPersonalizacion> tiposPersonalizacion;

  public Area() {}

  public Area(String lugarPersonalizable) {
    this.tiposPersonalizacion = new ArrayList<>();
    this.lugarPersonalizable = lugarPersonalizable;
  }

  public void agregarTipoPersonalizacion(TipoPersonalizacion tipoPersonalizacion){
    this.tiposPersonalizacion.add(tipoPersonalizacion);
  }


}
