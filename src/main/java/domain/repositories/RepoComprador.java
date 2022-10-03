package domain.repositories;

import domain.model.entities.comprador.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "compradores")
public interface RepoComprador extends JpaRepository<Comprador, Integer> {
}
