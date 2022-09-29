package domain.model.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Tienda")
@Getter
public class Tienda extends Persistente {

  @OneToMany
  @JoinColumn(name = "Tienda_id", referencedColumnName = "id")
  private List<Publicacion> publicaciones;

  public Tienda()
  {
    this.publicaciones = new ArrayList<>();
  }

}
