package domain.controllercomplement;

import domain.model.entities.producto.ProductoBase;
import domain.repositories.RepoProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RepositoryRestController
public class productoBaseController {

  @Autowired
  RepoProductoBase repoProductoBase;

  @Transactional
  @DeleteMapping("/productobase/{id}")
  public @ResponseBody ResponseEntity<Object> delete(@PathVariable("id") Integer id) {

    Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(id);

    //VALIDACIONES

    if(productoBaseOptional.isPresent()) {
      ProductoBase producto = productoBaseOptional.get();
      repoProductoBase.deleteById(id);

      return ResponseEntity.ok("materia borrada");
    }
      return new ResponseEntity<Object>("La materia no existe", HttpStatus.BAD_REQUEST);

  }



}
