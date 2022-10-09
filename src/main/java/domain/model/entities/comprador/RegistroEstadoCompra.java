package domain.model.entities.comprador;

import domain.model.entities.Persistente;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "Resitro_estado_compra")
public class RegistroEstadoCompra extends Persistente {

  @Column(name = "fecha")
  private LocalDate fechaCompra;

  @Column(name = "hora")
  private LocalTime horaCompra;

  @Enumerated(EnumType.STRING)
  private EstadoCompra estadoCompra;

  @ManyToOne
  @JoinColumn(name = "compra_id")
  private Compra compra;



}
