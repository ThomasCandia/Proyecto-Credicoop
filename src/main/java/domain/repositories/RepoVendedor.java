package domain.repositories;

import domain.model.entities.producto.ProductoBase;
import domain.model.entities.vendedor.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "vendedores")
public interface RepoVendedor extends JpaRepository<Vendedor, Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(Vendedor vendedor);


}
