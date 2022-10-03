package domain.repositories;

import domain.model.entities.producto.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import javax.persistence.criteria.CriteriaBuilder;

@RepositoryRestResource(path = "productobase")
public interface RepoProductoBaseSpring extends JpaRepository<ProductoBase, Integer> {

  public ProductoBase findProductoBaseByNombre(String nombre);



}
