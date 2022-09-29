package domain.model.entities.vendedor;

import domain.model.entities.Tienda;
import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
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

  @Transient
  //TODO ver si hacer una entidad a Metodos de Pago
  private List<MetodosDePago> metodosDePago;

  @OneToMany
  @JoinColumn(name = "Vendedor_Id", referencedColumnName = "id")
  private List<ProductoPersonalizado> productosPersonalizados;

  public Vendedor() {}

  public Vendedor(Tienda tienda) {
    this.metodosDePago = new ArrayList<>();
    this.productosPersonalizados = new ArrayList<>();
    this.tienda = tienda;
  }

}
