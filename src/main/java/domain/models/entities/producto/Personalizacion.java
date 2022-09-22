package domain.models.entities.producto;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Personalizacion")
@Setter @Getter
public class Personalizacion extends Persistente {

  @Column(name = "Descripcion")
  private String descripcion;

  @Column(name = "TipoPersonalizacion")
  private TipoPersonalizacion tipoPersonalizacion;

  @Column(name = "AreaPersonalizable")
  private Area areaPersonalizable;

  @Column(name = "Precio")
  private Double precio;
}
