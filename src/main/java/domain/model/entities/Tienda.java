package domain.model.entities;

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
