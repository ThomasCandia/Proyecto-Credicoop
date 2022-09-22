package domain.models.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Tienda")
@Getter
public class Tienda extends Persistente {

  private List<Publicacion> publicaciones;

  public Tienda()
  {
    this.publicaciones = new ArrayList<>();
  }

}
