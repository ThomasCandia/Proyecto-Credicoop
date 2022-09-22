package domain.models.entities.vendedor;

import domain.models.entities.Persistente;
import domain.models.entities.Tienda;
import domain.models.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vendedor")
@Setter @Getter
public class Vendedor extends Persistente {

  @OneToOne
  private Tienda tienda;
  //TODO ver si hacer una entidad a Metodos de Pago
  private List<MetodosDePago> metodosDePago;
  @OneToMany // TODO ver a que hace referencia cada campo
  @JoinColumn(name = "Vendedor_Id", referencedColumnName = "id")
  private List<ProductoPersonalizado> productosPersonalizados;

  public Vendedor() {}

  public Vendedor(Tienda tienda) {
    this.metodosDePago = new ArrayList<>();
    this.productosPersonalizados = new ArrayList<>();
    this.tienda = tienda;
  }

}
