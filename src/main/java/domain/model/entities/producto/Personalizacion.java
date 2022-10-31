package domain.model.entities.producto;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Personalizacion")
@Setter @Getter
public class Personalizacion extends Persistente {

  @Column(name = "Descripcion")
  private String descripcion;

  @Column(name = "Precio")
  private Double precio;

  @ManyToOne
  private TipoPersonalizacion tipoPersonalizacion;

  @OneToOne
  @JoinColumn(name = "Area_id")
  private Area areaPersonalizable;

  public Personalizacion() {}

  public Personalizacion(String descripcion, Double precio, TipoPersonalizacion tipoPersonalizacion, Area areaPersonalizable) {
    this.descripcion = descripcion;
    this.precio = precio;
    this.tipoPersonalizacion = tipoPersonalizacion;
    this.areaPersonalizable = areaPersonalizable;
  }
}

// TODO validacion : Fijarme si el area acepta el tipo de personalizacion y despues fijarme si
// el producto base contiene al area de la personalizacion