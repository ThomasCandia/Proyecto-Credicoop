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

  public Area() {}

  public Area(String lugarPersonalizable) {
    this.lugarPersonalizable = lugarPersonalizable;
  }


}
