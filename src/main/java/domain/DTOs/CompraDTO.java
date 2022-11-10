package domain.DTOs;

import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter@Setter
public class CompraDTO {

  private Integer metodoDePagoId;


}
