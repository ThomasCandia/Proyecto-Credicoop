package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Area")
@Setter @Getter
public class Area extends Persistente {

@Column(name = "Lugar_Personalizable")
  private String lugarPersonalizable;

  @ManyToMany
  private List<TipoPersonalizacion> tiposPersonalizacion;

public Area()
{
this.tiposPersonalizacion = new ArrayList<>();
}

  public Area(String lugarPersonalizable)
  {
    this.tiposPersonalizacion = new ArrayList<>();
    this.lugarPersonalizable = lugarPersonalizable;
  }

}
