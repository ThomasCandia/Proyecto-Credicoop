package domain.model.entities;

import domain.model.entities.producto.ProductoPersonalizado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Publicacion")
@Setter @Getter
public class Publicacion extends Persistente {

  @Column(name = "nombre")
  private String nombre;

  @OneToOne
  private ProductoPersonalizado productoPublicado;

  //Bidireccional
  @OneToMany(mappedBy = "publicacion")
  private List<RegistroEstado> registrosEstados;

  public Publicacion() {}

  public Publicacion(String nombre,ProductoPersonalizado productoPublicado)
  {
    this.nombre = nombre;
    this.productoPublicado = productoPublicado;
    this.registrosEstados = new ArrayList<>();
  }

  public RegistroEstado estadoActual(){

    int tamanio = this.registrosEstados.size();
    return this.registrosEstados.get(tamanio-1);
  }

  public void agregarRegistro(RegistroEstado registroEstado){
    this.registrosEstados.add(registroEstado);
  }



}
