package domain.repositories;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "areas")
public interface RepoArea extends JpaRepository<Area,Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(Area area);

}
