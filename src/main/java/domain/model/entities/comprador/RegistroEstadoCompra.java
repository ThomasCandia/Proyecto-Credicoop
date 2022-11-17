package domain.model.entities.comprador;

import domain.model.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter@Setter
@Table(name = "Resitro_estado_compra")
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


  public RegistroEstadoCompra() {}

  public RegistroEstadoCompra(LocalDate fechaCompra, LocalTime horaCompra, EstadoCompra estadoCompra, Compra compra) {
    this.fechaCompra = fechaCompra;
    this.horaCompra = horaCompra;
    this.estadoCompra = estadoCompra;
    this.compra = compra;
  }
}
