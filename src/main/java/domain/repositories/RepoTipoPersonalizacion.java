package domain.repositories;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.TipoPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "tipopersonalizacion")
public interface RepoTipoPersonalizacion extends JpaRepository<TipoPersonalizacion, Integer> {
  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(Area area);


}
