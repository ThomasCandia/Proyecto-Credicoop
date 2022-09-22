package domain.models.entities.comprador;

import domain.models.entities.Persistente;
import domain.models.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra extends Persistente {

  @ManyToMany
  private List<ProductoPersonalizado> productosAComprar;
  
  public CarritoDeCompra() {
    this.productosAComprar = new ArrayList<>();
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
