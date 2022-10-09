package domain.model.entities.publicacion;

import domain.model.entities.Persistente;
import domain.model.entities.publicacion.EstadoPublicacion;
import domain.model.entities.publicacion.Publicacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Resgistro_estado_publicacion")
public class RegistroEstadoPublicacion extends Persistente {

  @Column(name = "fecha")
  private  LocalDate fecha;

  @Column(name = "hora")
  private  LocalTime hora;

  @Enumerated(EnumType.STRING)
  private EstadoPublicacion estadoPublicacion;

  @ManyToOne
  @JoinColumn(name = "publicacion_id")
  private Publicacion publicacion;


}
