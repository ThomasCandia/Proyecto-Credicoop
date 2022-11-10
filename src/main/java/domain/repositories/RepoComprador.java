package domain.repositories;

import domain.model.entities.comprador.Comprador;
import domain.model.entities.producto.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "compradores")
public interface RepoComprador extends JpaRepository<Comprador, Integer> {

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(Comprador comprador);

  Optional<Comprador>findCompradorById(Integer id);

}
