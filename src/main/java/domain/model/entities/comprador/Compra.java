package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.vendedor.MetodoDePago;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Compra extends Persistente {

  @ManyToOne
  @JoinColumn(name = "metodo_pago_id", referencedColumnName = "id")
  private MetodoDePago metodoDePago;

  @OneToMany
  private Set<Item> itemsComprados;

  @OneToMany
  private List<RegistroEstadoCompra> registroEstadosCompra;

  public Compra() {}

  public Compra(MetodoDePago metodoDePago) {
    this.metodoDePago = metodoDePago;
    this.itemsComprados = new HashSet<>();
  }

  public RegistroEstadoCompra getEstadoActual(){
    int tamanio = this.registroEstadosCompra.size();
    return this.registroEstadosCompra.get(tamanio-1);
  }

  public void agregarItem(Item item){
    itemsComprados.add(item);
  }

  //TODO fijarse si hacer la factura acá
  //public getFactura();
}
