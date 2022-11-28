package domain.DTOs;

import domain.model.entities.comprador.EstadoCompra;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter@Setter
public class RegistroCompraDTO {

  private EstadoCompra estadoCompra;
  private LocalDateTime fechaHoraCompra;



  public RegistroCompraDTO(LocalDateTime fechaHoraCompra, EstadoCompra estadoCompra) {

    this.fechaHoraCompra = fechaHoraCompra;
    this.estadoCompra = estadoCompra;
  }
}
