package domain.model.entities.vendedor;

import domain.model.entities.publicacion.Tienda;
import domain.model.entities.Persistente;
import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vendedor")
@Setter@Getter
public class Vendedor extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private Tienda tienda;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<MetodoDePago> metodosDePagos;

  @OneToMany
  private List<ProductoPersonalizado> productosPersonalizados;

  public Vendedor() {
    this.metodosDePagos = new ArrayList<>();
    this.productosPersonalizados = new ArrayList<>();
  }

  public Vendedor(String nombre, String apellido, List<MetodoDePago> metodosDePagos) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.tienda = new Tienda();
    this.metodosDePagos = metodosDePagos;
    this.productosPersonalizados = new ArrayList<>();
  }


  public void agregarProducto(ProductoPersonalizado productoPersonalizado) {
    this.productosPersonalizados.add(productoPersonalizado);
  }

  public boolean tieneElProducto(ProductoPersonalizado productoPersonalizado){
    return this.productosPersonalizados.contains(productoPersonalizado);
  }

}
