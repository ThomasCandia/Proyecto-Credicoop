package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AreaPorProductoBase")
@Getter@Setter
public class AreaPorProductoBase extends Persistente {

  @ManyToOne
  @JoinColumn(name = "Area_id", referencedColumnName = "id")
  private Area area;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private List<TipoPersonalizacion> tiposPersonalizacion;

  public AreaPorProductoBase(){
    this.tiposPersonalizacion = new ArrayList<>(); //TODO hacer esto con todos los constructores vacios!!!!!!!!!!
  }

  public AreaPorProductoBase(Area area) {
    this.area = area;
    this.tiposPersonalizacion = new ArrayList<>();
  }

  public void agregarTipoPersonalizacion(TipoPersonalizacion tipoPersonalizacion) {
    this.tiposPersonalizacion.add(tipoPersonalizacion);
  }

  public Boolean validarPersonalizacion(Personalizacion personalizacion) {
    return personalizacion.getAreaPersonalizable().equals(this.area) && this.tiposPersonalizacion.stream().anyMatch(tipoP -> tipoP.equals(personalizacion. getTipoPersonalizacion()));
  }

}
