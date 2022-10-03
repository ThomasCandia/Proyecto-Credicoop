package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra extends Persistente {

  @ManyToMany(fetch = FetchType.EAGER)
  private List<ProductoPersonalizado> productosAComprar;

  public CarritoDeCompra() {this.productosAComprar = new ArrayList<>();}

  public CarritoDeCompra(List<ProductoPersonalizado> productosAComprar) {
    this.productosAComprar = productosAComprar;
  }

  public void agregarProducto(ProductoPersonalizado productoPersonalizado){
    this.productosAComprar.add(productoPersonalizado);
  }

  public void eliminarProducto(ProductoPersonalizado productoPersonalizado){
    this.productosAComprar.remove(productoPersonalizado);
  }

  public Double calcularTotal(){
    return this.productosAComprar.stream().mapToDouble(ProductoPersonalizado::calcularPrecioFinal).sum();
  }

}
