package domain.controllercomplement;

import domain.DTOs.*;
import domain.model.entities.comprador.CarritoDeCompra;
import domain.model.entities.comprador.Compra;
import domain.model.entities.comprador.EstadoCompra;
import domain.model.entities.comprador.RegistroEstadoCompra;
import domain.model.entities.producto.ProductoPersonalizado;
import domain.model.entities.publicacion.EstadoPublicacion;
import domain.model.entities.publicacion.Publicacion;

import domain.model.entities.publicacion.RegistroEstadoPublicacion;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static domain.model.entities.comprador.EstadoCompra.PENDIENTE;

@RepositoryRestController
public class vendedorController {

  @Autowired
  RepoMetodoDePago repoMetodoDePago;

  @Autowired
  RepoVendedor repoVendedor;

  @Autowired
  RepoCompra repoCompra;

  @Autowired
  RepoRegistroCompra repoRegistroCompra;

  @Autowired
  RepoProductoPersonalizado repoProductoPersonalizado;

  @Autowired
  RepoPublicacion repoPublicacion;

  @Transactional
  @PostMapping("/vendedores")
  public @ResponseBody ResponseEntity<Object> crearVendedor(@RequestBody VendedorDTO vendedorDTO) {


    List<Integer> listaDeMetodosDePagoIDs = vendedorDTO.getMetodosDePagoId();
    //OBTENEMOS TODOS LOS METODOS DE PAGO
    List<Optional<MetodoDePago>> listaDeMetodosDePagoOptional = listaDeMetodosDePagoIDs.stream().map(pago -> repoMetodoDePago.findById(pago)).collect(Collectors.toList());

    //VALIDAMOS LOS METODOS DE PAGO
    if (listaDeMetodosDePagoOptional.stream().allMatch(metodo -> metodo.isPresent())) {
      List<MetodoDePago> listaDeMetodosDePago = listaDeMetodosDePagoOptional.stream().map(pago -> pago.get()).collect(Collectors.toList());


      Vendedor nuevoVendedor = new Vendedor(vendedorDTO.getNombre(), vendedorDTO.getApellido(), listaDeMetodosDePago);
      repoVendedor.save(nuevoVendedor);

      return new ResponseEntity<Object>("El vendedor fue creado con éxito", HttpStatus.CREATED);
    }
    return new ResponseEntity<Object>("Alguno de los métodos de pago no existe", HttpStatus.NOT_FOUND);
  }

  //TODO preguntar a ezequiel si estaria bien un verbo en el path
  @Transactional
  @PostMapping("/vendedores/{compraID}/confirmar")
  public @ResponseBody ResponseEntity<Object> confirmarCompra(@PathVariable("compraID") Integer compraID) {

    //BUSCAMOS LA COMPRA
    Optional<Compra> compra = repoCompra.findById(compraID);

    if (compra.isPresent()) {

      //CAMBIAMOS EL ESTADO DE LA COMPRA

      LocalDateTime fechaHora = LocalDateTime.now();

      RegistroEstadoCompra nuevoRegistro = new RegistroEstadoCompra(fechaHora, EstadoCompra.CONFIRMADA, compra.get());
      repoRegistroCompra.save(nuevoRegistro);

      compra.get().getRegistroEstadosCompra().add(nuevoRegistro);
      repoCompra.save(compra.get());

      // REALIZAMOS LA FACTURA

      List<ItemDTO2> itemsCarrito = compra.get().getCarritoDeCompra().getItemsAComprar().stream().map(item -> new ItemDTO2(item.getCantidad(),new ProductoPersonalizadoDTO2(item.getProductoPersonalizado().getProductoBase().getNombre(),item.getProductoPersonalizado().calcularPrecioFinal()),item.calcularPrecio())).collect(Collectors.toList());

      Double precioTotal = compra.get().getCarritoDeCompra().calcularTotal();

      FacturaDTO factura = new FacturaDTO(compra.get().getMetodoDePago().getMetodoDePago(),
          compra.get().getComprador().getNombre(),itemsCarrito,new RegistroCompraDTO(fechaHora, nuevoRegistro.getEstadoCompra()),compra.get().getVendedor().getNombre(),precioTotal);

      return new ResponseEntity<>(new RespuestaDTO(new Mensaje("La venta fue confirmada con éxito"),factura), HttpStatus.CREATED);


    }

    return new ResponseEntity<Object>("LA VENTA INGRESADA NO FUE ENCONTRADA", HttpStatus.NOT_FOUND);

  }

  @Transactional
  @PostMapping("/vendedores/{compraID}/rechazar")
  public @ResponseBody ResponseEntity<Object> rechazarCompra(@PathVariable("compraID") Integer compraID) {

    //BUSCAMOS LA COMPRA
    Optional<Compra> compra = repoCompra.findById(compraID);

    if (compra.isPresent()) {

      //CAMBIAMOS EL ESTADO DE LA COMPRA
      LocalDateTime fechaHora = LocalDateTime.now();

      RegistroEstadoCompra nuevoRegistro = new RegistroEstadoCompra(fechaHora, EstadoCompra.RECHAZADA, compra.get());
      repoRegistroCompra.save(nuevoRegistro);

      compra.get().getRegistroEstadosCompra().add(nuevoRegistro);
      repoCompra.save(compra.get());

      return new ResponseEntity<Object>("La venta fue rechazada", HttpStatus.ACCEPTED);
    }

    return new ResponseEntity<Object>("LA VENTA INGRESADA NO FUE ENCONTRADA", HttpStatus.NOT_FOUND);

  }

  @Transactional
  @PostMapping("/vendedores/{vendedorID}/publicaciones")
  public @ResponseBody ResponseEntity<Object> subirPublicacion(@PathVariable("vendedorID") Integer vendedorID,
                                                               @RequestBody PublicacionDTO publicacionDTO) {

    Integer id = publicacionDTO.getProductoPersonalizadoId();
    Optional<ProductoPersonalizado> productoPersonalizadoAPublicar = repoProductoPersonalizado.findById(id);
    Optional<Vendedor> vendedor = repoVendedor.findById(vendedorID);

    if (productoPersonalizadoAPublicar.isPresent()) {

      if (vendedor.isPresent()) {

        if(vendedor.get().tieneElProducto(productoPersonalizadoAPublicar.get())) {

          productoPersonalizadoAPublicar.get().setEstaPublicado(true);
          Publicacion publicacion = new Publicacion(publicacionDTO.getNombre(),productoPersonalizadoAPublicar.get());
          LocalDateTime fechaHora = LocalDateTime.now();
          publicacion.agregarRegistro(new RegistroEstadoPublicacion(fechaHora, EstadoPublicacion.ACTIVA,publicacion));
          vendedor.get().getTienda().agregarPublicacion(publicacion);
          repoPublicacion.save(publicacion);


          return new ResponseEntity<Object>("El producto fue publicado con éxito", HttpStatus.ACCEPTED);

        }
        return new ResponseEntity<Object>("NO TIENE EL PRODUCTO ESCOGIDO", HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<Object>("El VENDEDOR NO FUE ENCONTRADO", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Object>("El PRODUCTO PERSONALIZADO NO FUE ENCONTRADO", HttpStatus.NOT_FOUND);
  }

}
