package domain.repositories;

import domain.model.entities.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "publicaciones")
public interface RepoPublicacion extends JpaRepository<Publicacion, Integer> {
}
