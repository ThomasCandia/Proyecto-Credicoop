package domain.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductoPersonalizadoDTO2 {

  private String nombre;
  private Double precio;

  public ProductoPersonalizadoDTO2(String nombre, Double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }
}
