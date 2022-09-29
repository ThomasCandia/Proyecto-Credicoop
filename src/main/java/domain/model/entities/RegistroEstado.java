package domain.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Resgistro_estado")
public class RegistroEstado extends Persistente {

  @Column(name = "fecha")
  private  LocalDate fecha;

  @Column(name = "hora")
  private  LocalTime hora;

  @Enumerated(EnumType.STRING)
  private EstadoPublicacion estadoPublicacion;


}
