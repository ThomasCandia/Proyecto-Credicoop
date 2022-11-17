package domain.model.entities.publicacion;

import domain.model.entities.Persistente;
import domain.model.entities.publicacion.EstadoPublicacion;
import domain.model.entities.publicacion.Publicacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Resgistro_estado_publicacion")
@Getter@Setter
public class RegistroEstadoPublicacion extends Persistente {

  @Column(name = "fecha")
  private  LocalDate fechaPublicacion;

  @Column(name = "hora")
  private  LocalTime horaPublicacion;

  @Enumerated(EnumType.STRING)
  private EstadoPublicacion estadoPublicacion;

  @ManyToOne
  @JoinColumn(name = "publicacion_id")
  private Publicacion publicacion;


  public RegistroEstadoPublicacion() {}

  public RegistroEstadoPublicacion(LocalDate fechaPublicacion, LocalTime horaPublicacion, EstadoPublicacion estadoPublicacion, Publicacion publicacion) {
    this.fechaPublicacion = fechaPublicacion;
    this.horaPublicacion = horaPublicacion;
    this.estadoPublicacion = estadoPublicacion;
    this.publicacion = publicacion;
  }
}
