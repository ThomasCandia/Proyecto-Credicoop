package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.MetodoDePago;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Compra extends Persistente {

  @ManyToOne
  @JoinColumn(name = "metodo_pago_id", referencedColumnName = "id")
  private MetodoDePago metodoDePago;
  
  public MetodoDePago getMetodoDePago() {
    return metodoDePago;
  }

  public void setMetodoDePago(MetodoDePago metodoDePago) {
    this.metodoDePago = metodoDePago;
  }
}
