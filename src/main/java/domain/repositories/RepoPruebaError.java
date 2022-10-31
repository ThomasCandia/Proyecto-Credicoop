package domain.repositories;

import domain.model.entities.ClasePruebaError;
import domain.model.entities.producto.ProductoBase;
import domain.model.entities.producto.TipoPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "pruebaerror")
public interface RepoPruebaError extends JpaRepository<ClasePruebaError, Integer> {
}
