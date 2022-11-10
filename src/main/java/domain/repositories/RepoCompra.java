package domain.repositories;


import domain.model.entities.comprador.Compra;
import domain.model.entities.vendedor.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "compra")
public interface RepoCompra extends JpaRepository<Compra,Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(Compra compra);

}