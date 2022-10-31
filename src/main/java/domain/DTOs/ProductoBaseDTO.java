package domain.DTOs;

import domain.model.entities.producto.AreaPorProductoBase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class ProductoBaseDTO {

  private String nombre;

  private Double precioBase;

  private String descripcion;

  private String tiempoFabricacion;

  private List<AreaPorProductoBaseDTO> areasPorProductoBase;

  public ProductoBaseDTO() {}

  public ProductoBaseDTO(String nombre, Double precioBase, String descripcion, String tiempoFabricacion, List<AreaPorProductoBaseDTO> areasPorProductoBase) {
    this.nombre = nombre;
    this.precioBase = precioBase;
    this.descripcion = descripcion;
    this.tiempoFabricacion = tiempoFabricacion;
    this.areasPorProductoBase = areasPorProductoBase;
  }
}
