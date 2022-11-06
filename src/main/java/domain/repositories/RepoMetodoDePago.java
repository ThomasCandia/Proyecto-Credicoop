package domain.repositories;

import domain.model.entities.producto.Area;
import domain.model.entities.vendedor.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "metodosdepago")
public interface RepoMetodoDePago extends JpaRepository<MetodoDePago,Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(MetodoDePago metodoDePago);

}
