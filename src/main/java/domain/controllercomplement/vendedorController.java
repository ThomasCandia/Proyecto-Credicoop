package domain.controllercomplement;

import domain.DTOs.VendedorDTO;
import domain.model.entities.producto.Area;
import domain.model.entities.publicacion.Tienda;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.RepoMetodoDePago;
import domain.repositories.RepoVendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RepositoryRestController
public class vendedorController {

  @Autowired
  RepoMetodoDePago repoMetodoDePago;

  @Autowired
  RepoVendedor repoVendedor;

  @Transactional
  @PostMapping("/vendedores")
  @ResponseBody
  ResponseEntity<Object> crearVendedor(@RequestBody VendedorDTO vendedorDTO){


    List<Integer> listaDeMetodosDePagoIDs = vendedorDTO.getMetodosDePagoId();
    //OBTENEMOS TODOS LOS METODOS DE PAGO
    List<Optional<MetodoDePago>> listaDeMetodosDePagoOptional = listaDeMetodosDePagoIDs.stream().map(pago -> repoMetodoDePago.findById(pago)).collect(Collectors.toList());

    //VALIDAMOS LOS METODOS DE PAGO
    if(listaDeMetodosDePagoOptional.stream().allMatch(metodo -> metodo.isPresent()))
    {
      List<MetodoDePago> listaDeMetodosDePago = listaDeMetodosDePagoOptional.stream().map(pago -> pago.get()).collect(Collectors.toList());

      Vendedor nuevoVendedor = new Vendedor(vendedorDTO.getNombre(),vendedorDTO.getApellido(),new Tienda(),listaDeMetodosDePago);
      repoVendedor.save(nuevoVendedor);

      return new ResponseEntity<Object>("El vendedor fue creado con éxito", HttpStatus.CREATED);
    }
    return new ResponseEntity<Object>("Alguno de los métodos de pago no existe", HttpStatus.NOT_FOUND);
  }

}
