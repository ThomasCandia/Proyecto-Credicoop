package domain.repositories;

import domain.model.entities.producto.ProductoBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "productobase")
public interface RepoProductoBase extends JpaRepository<ProductoBase, Integer> {

  //public ProductoBase findProductoBaseByNombre(String nombre);

  @RestResource(exported = false)
  void deleteById(Integer id);

  @RestResource(exported = false)
  void delete(ProductoBase productoBase);

  // TODO probar postman con paginas
  Page<ProductoBase> findProductoBaseByNombre(String nombre, Pageable pageable);

}
