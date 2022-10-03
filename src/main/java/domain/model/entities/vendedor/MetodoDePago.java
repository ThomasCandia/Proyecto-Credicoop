package domain.model.entities.vendedor;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MetodoDePago")
@Setter @Getter
public class MetodoDePago extends Persistente {

  @Column(name = "MetodoDePago")
  private String metodoDePago;

  public MetodoDePago(){}

  public MetodoDePago(String metodoDePago) {
    this.metodoDePago = metodoDePago;
  }
}
