package domain.model.entities.publicacion;

import domain.model.entities.Persistente;
import domain.model.entities.publicacion.EstadoPublicacion;
import domain.model.entities.publicacion.Publicacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Resgistro_estado_publicacion")
@Getter@Setter
public class RegistroEstadoPublicacion extends Persistente {

  @Column(name = "fecha")
  private LocalDateTime fechaHoraPublicacion;

  @Enumerated(EnumType.STRING)
  private EstadoPublicacion estadoPublicacion;

  @ManyToOne
  @JoinColumn(name = "publicacion_id")
  private Publicacion publicacion;


  public RegistroEstadoPublicacion() {}

  public RegistroEstadoPublicacion(LocalDateTime fechaHoraPublicacion, EstadoPublicacion estadoPublicacion, Publicacion publicacion) {
    this.fechaHoraPublicacion = fechaHoraPublicacion;
    this.estadoPublicacion = estadoPublicacion;
    this.publicacion = publicacion;
  }
}
