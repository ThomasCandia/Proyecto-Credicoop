package domain.controllercomplement;

import domain.DTOs.CompraDTO;
import domain.DTOs.ItemDTO;
import domain.model.entities.comprador.*;
import domain.model.entities.producto.ProductoPersonalizado;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.RepoCompra;
import domain.repositories.RepoComprador;
import domain.repositories.RepoMetodoDePago;
import domain.repositories.RepoProductoPersonalizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RepositoryRestController
public class compradorController {

  @Autowired
  RepoComprador repoComprador;
  @Autowired
  RepoProductoPersonalizado repoProductoPersonalizado;
  @Autowired
  RepoMetodoDePago repoMetodoDePago;
  @Autowired
  RepoCompra repoCompra;

  @Transactional
  @PostMapping("/compradores/{compradorID}/carritodecompra/items")
  public @ResponseBody ResponseEntity<Object> agregarItem(@PathVariable ("compradorID") Integer compradorID,
                                                   @RequestBody ItemDTO itemDTO) throws Exception {

    Optional<Comprador> comprador = repoComprador.findById(compradorID);
    Optional<ProductoPersonalizado> productoPersonalizado = repoProductoPersonalizado.findById(itemDTO.getProductoPersonalizadoID());

    if (comprador.isPresent() && productoPersonalizado.isPresent()) {

      Item itemAAgregar = new Item(itemDTO.getCantidad(), productoPersonalizado.get());
      comprador.get().getCarritoActual().agregarProducto(itemAAgregar);

      return new ResponseEntity<>("Item agregado con exito", HttpStatus.ACCEPTED);

    }

    return new ResponseEntity<>("El comprador o el producto elegido no existe", HttpStatus.NOT_FOUND);

  }

  @Transactional
  @DeleteMapping("/compradores/{compradorID}/carritodecompra/items")
  public @ResponseBody ResponseEntity<Object> borrarItem(@PathVariable ("compradorID") Integer compradorID,
                                                   @RequestBody Integer itemID) throws Exception {

    Optional<Comprador> comprador = repoComprador.findById(compradorID);

    if (comprador.isPresent()) {

      comprador.get().getCarritoActual().eliminarProducto(itemID);

      return new ResponseEntity<>("Item borrado con exito", HttpStatus.OK);

    }
    return new ResponseEntity<>("El comprador no existe", HttpStatus.NOT_FOUND);
  }


  @Transactional
  @GetMapping("/compradores/{compradorID}/carritodecompra")
  public @ResponseBody ResponseEntity<Object> mostrarItems(@PathVariable("compradorID") Integer compradorID)
  {
    Optional<Comprador> comprador = repoComprador.findById(compradorID);
    if(comprador.isPresent()) {
      return new ResponseEntity<>(comprador.get().getCarritoActual(), HttpStatus.OK);
    }

  return new ResponseEntity<>("El comprador no existe", HttpStatus.NOT_FOUND);

  }

  @Transactional
  @PostMapping("/compradores/{compradorID}/compra")
  public @ResponseBody ResponseEntity<Object> comprar(@PathVariable("compradorID") Integer compradorID, @RequestBody CompraDTO compraDTO) throws Exception {

    Optional<Comprador> comprador = repoComprador.findById(compradorID);
    Optional<MetodoDePago> metodoDePagoElegido = repoMetodoDePago.findById(compraDTO.getMetodoDePagoId());


    //VALIDO SI EL COMPRADOR EXISTE
    if(comprador.isPresent()) {

      //VALIDO SI EXISTE EL METODO DE PAGO
      if(metodoDePagoElegido.isPresent()) {

        Vendedor vendedorElegido = comprador.get().getCarritoActual().vendedorElegido();

        //VALIDO SI EL VENDEDOR ACEPTA EL METODO DE PAGO SELECCIONADO
        if(vendedorElegido.getMetodosDePagos().contains(metodoDePagoElegido.get())) {

          LocalDateTime fechaDeHoy = LocalDateTime.now();

          Compra nuevaCompra = new Compra(metodoDePagoElegido.get(),comprador.get().getCarritoActual(),comprador.get(),vendedorElegido);

          nuevaCompra.getRegistroEstadosCompra().add(new RegistroEstadoCompra(fechaDeHoy, PENDIENTE,nuevaCompra));

          repoCompra.save(nuevaCompra); //TODO ver si le asigna el id al registro

          comprador.get().getCarritosDeCompra().add(new CarritoDeCompra());

          return new ResponseEntity<>("La compra fue realizada con éxito", HttpStatus.CREATED);

        }
        return new ResponseEntity<>("EL VENDEDOR NO ACEPTA EL METODO DE PAGO", HttpStatus.BAD_REQUEST);

      }

      return new ResponseEntity<>("El método de pago no existe", HttpStatus.NOT_FOUND);

    }

    return new ResponseEntity<>("El comprador no existe", HttpStatus.NOT_FOUND);

  }

}
