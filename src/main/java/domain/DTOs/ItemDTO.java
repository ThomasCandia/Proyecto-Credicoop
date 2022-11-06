package domain.DTOs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter@Setter
public class ItemDTO {

  private Integer productoPersonalizadoID;

  private int cantidad;

}
