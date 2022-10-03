package domain.repositories;

import domain.model.entities.producto.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "areas")
public interface RepoArea extends JpaRepository<Area,Integer> {

}
