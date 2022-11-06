package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Compras")
@Getter @Setter
public class Compra extends Persistente {

  @ManyToOne
  @JoinColumn(name = "metodo_pago_id", referencedColumnName = "id")
  private MetodoDePago metodoDePago;

  @OneToOne
  private CarritoDeCompra carritoDeCompra;

  @OneToMany
  private List<RegistroEstadoCompra> registroEstadosCompra;

  @ManyToOne
  private Comprador comprador;

  @ManyToOne
  private Vendedor vendedor;

  public Compra() {
    this.registroEstadosCompra = new ArrayList<>();
  }

  public Compra(MetodoDePago metodoDePago, CarritoDeCompra carritoDeCompra, Comprador comprador, Vendedor vendedor) {
    this.metodoDePago = metodoDePago;
    this.carritoDeCompra = carritoDeCompra;
    this.comprador = comprador;
    this.vendedor = vendedor;
    this.registroEstadosCompra = new ArrayList<>();
  }

  public RegistroEstadoCompra getEstadoActual(){
    int tamanio = this.registroEstadosCompra.size();
    return this.registroEstadosCompra.get(tamanio-1);
  }

  public Double precioCompra(){
    return this.carritoDeCompra.calcularTotal();
  }

  //TODO hacer la factura acá
  //public getFactura();
}
