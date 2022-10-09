package domain.model.entities.publicacion;

import domain.model.entities.Persistente;
import domain.model.entities.publicacion.Publicacion;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Tienda")
@Getter
public class Tienda extends Persistente {

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "Tienda_id", referencedColumnName = "id")
  private List<Publicacion> publicaciones;

  public Tienda()
  {
    this.publicaciones = new ArrayList<>();
  }

}
