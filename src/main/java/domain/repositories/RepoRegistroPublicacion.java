package domain.repositories;

import domain.model.entities.comprador.RegistroEstadoCompra;
import domain.model.entities.publicacion.RegistroEstadoPublicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "registropublicaciones")
public interface RepoRegistroPublicacion extends JpaRepository<RegistroEstadoPublicacion, Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(RegistroEstadoPublicacion registroEstadoPublicacion);

}
