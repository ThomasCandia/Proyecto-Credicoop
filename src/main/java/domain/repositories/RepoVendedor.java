package domain.repositories;

import domain.model.entities.vendedor.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "vendedores")
public interface RepoVendedor extends JpaRepository<Vendedor, Integer> {



}
