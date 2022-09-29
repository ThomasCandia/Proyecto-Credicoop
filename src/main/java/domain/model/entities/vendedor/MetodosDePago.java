package domain.model.entities.vendedor;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

// TODO Ver si poner a metodo de pago como una entidad
@Setter @Getter
public class MetodosDePago {
  private String metodosPago;

  public MetodosDePago(){}

  public MetodosDePago(String metodosPago)
  {
    this.metodosPago = metodosPago;
  }
}
