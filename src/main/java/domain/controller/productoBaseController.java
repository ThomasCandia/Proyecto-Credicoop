package domain.controller;

import domain.repositories.RepoProductoBaseSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productobase")
public class productoBaseController {
  @Autowired
  RepoProductoBaseSpring repoProductoBaseSpring;

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") Integer id) {
    repoProductoBaseSpring.deleteById(id);
    return "borrado con exito";
  }


}
