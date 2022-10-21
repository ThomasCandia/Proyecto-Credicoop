package domain.controllercomplement;

import domain.model.entities.producto.Personalizacion;
import domain.model.entities.producto.ProductoBase;
import domain.model.entities.producto.ProductoPersonalizado;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.RepoProductoBase;
import domain.repositories.RepoProductoPersonalizado;
import domain.repositories.RepoVendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RepositoryRestController
public class productoPersonalizadoController {

  @Autowired
  RepoProductoPersonalizado repoProductoPersonalizado;

  @Autowired
  RepoProductoBase repoProductoBase;



  @Transactional
  @PostMapping("/productospersonalizados")
  public @ResponseBody
  ResponseEntity<Object> save(@RequestBody ProductoPersonalizado productoPersonalizado) {

    repoProductoBase.save(productoPersonalizado.getProductoBase());

    //VALIDACIONES

    if(productoPersonalizado.getProductoBase() != null) {


      // 2° VALIDAR QUE LAS PERSONALIZACIONES SEAN ACEPTADAS EN LAS AREAS

      List<Personalizacion> personalizaciones = productoPersonalizado.getPersonalizaciones();
      boolean valid = personalizaciones.stream().allMatch(personalizacion -> productoPersonalizado.getProductoBase().validarPersonalizacion(personalizacion));

      if (valid) {
        repoProductoPersonalizado.save(productoPersonalizado);
        return new ResponseEntity<Object>("Creado con exito", HttpStatus.CREATED);
      } else {
        return new ResponseEntity<Object>("No es posible esa personalizacion", HttpStatus.BAD_REQUEST);
      }
    }

    return new ResponseEntity<Object>("El producto base no existe", HttpStatus.NOT_FOUND);
  }







}
