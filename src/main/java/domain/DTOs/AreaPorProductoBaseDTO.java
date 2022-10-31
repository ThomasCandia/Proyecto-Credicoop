package domain.DTOs;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.AreaPorProductoBase;
import domain.model.entities.producto.TipoPersonalizacion;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
@Setter
@Getter
public class AreaPorProductoBaseDTO {

  private Integer areaId;

  @NotNull
  private List<Integer> tiposPersonalizacionId;

  public AreaPorProductoBaseDTO() {}

  public AreaPorProductoBaseDTO(Integer areaId, List<Integer> tiposPersonalizacionId) {
    this.areaId = areaId;
    this.tiposPersonalizacionId = tiposPersonalizacionId;
  }
}
