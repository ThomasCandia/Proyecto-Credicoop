package domain.repositories;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.ProductoPersonalizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "productospersonalizados")
public interface RepoProductoPersonalizado extends JpaRepository<ProductoPersonalizado,Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(ProductoPersonalizado productoPersonalizado);

}
