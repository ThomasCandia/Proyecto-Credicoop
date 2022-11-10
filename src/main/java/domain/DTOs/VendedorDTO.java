package domain.DTOs;

import domain.model.entities.vendedor.MetodoDePago;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Getter@Setter
public class VendedorDTO {

  private String nombre;
  private String apellido;
  private List<Integer> metodosDePagoId;

}
