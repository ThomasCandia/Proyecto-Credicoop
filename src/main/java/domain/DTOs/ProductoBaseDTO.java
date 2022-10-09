package domain.DTOs;

import domain.model.entities.producto.ProductoBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="productoBase",types = {ProductoBase.class})
public interface ProductoBaseDTO {

  @Value("#{target.nombre} #{target.descripcion}")
  String getProducto();

  @Value("#{target.precioBase}")
  int getPrecio();

  @Value("#{target.tiempoFabricacion}")
  String getTiempoDeFabricacion();

}

