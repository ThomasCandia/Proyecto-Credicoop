package domain.models.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroEstado extends Persistente {

  @Column(name = "fecha")
private  LocalDate fecha;
  @Column(name = "hora")
private  LocalTime hora;
@Enumerated(EnumType.STRING)
  private EstadoPublicacion estadoPublicacion;
}
