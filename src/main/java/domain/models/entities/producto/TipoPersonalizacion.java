package domain.models.entities.producto;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Personalizacion")
@Setter @Getter
public class TipoPersonalizacion extends Persistente {

  @Column(name = "TipoPersonalizacion" )
  private String tipoPersonalizacion;


  public TipoPersonalizacion() {}

  public TipoPersonalizacion(String tipoPersonalizacion) {
    this.tipoPersonalizacion = tipoPersonalizacion;
  }
}
