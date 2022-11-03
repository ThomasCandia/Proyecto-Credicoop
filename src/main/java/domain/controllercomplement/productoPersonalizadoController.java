package domain.controllercomplement;

import domain.DTOs.PersonalizacionDTO;
import domain.DTOs.ProductoPersonalizadoDTO;
import domain.model.entities.producto.*;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RepositoryRestController
public class productoPersonalizadoController {

  @Autowired
  RepoProductoPersonalizado repoProductoPersonalizado;

  @Autowired
  RepoProductoBase repoProductoBase;

  @Autowired
  RepoArea repoArea;

  @Autowired
  RepoTipoPersonalizacion repoTipoPersonalizacion;

  @Autowired
  RepoVendedor repoVendedor;

  @Transactional
  @PostMapping("/vendedores/{vendedorID}/productospersonalizados")
  public @ResponseBody
  ResponseEntity<Object> crearProductoPersonalizado(@PathVariable("vendedorID") Integer vendedorID,
                                                    @RequestBody ProductoPersonalizadoDTO productoPersonalizadoDTO) {


    Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(productoPersonalizadoDTO.getProductoBaseId());
    List<PersonalizacionDTO> personalizacionesDTOList = productoPersonalizadoDTO.getPersonalizacionesDTO();

    //OBTENEMOS AL VENDEDOR
    Optional<Vendedor> vendedor = repoVendedor.findById(vendedorID);

    //OBTENEMOS LAS AREAS
    List<Integer> listaDeAreaIDs = personalizacionesDTOList.stream().map(perso -> perso.getAreaId()).collect(Collectors.toList());
    List<Optional<Area>> listaDeAreas = listaDeAreaIDs.stream().map(area -> repoArea.findById(area)).collect(Collectors.toList());

    //OBTENEMOS LOS TIPOS DE PERSONALIZACION
    List<Integer> listaDeTipoDePersonalizacionIDs = personalizacionesDTOList.stream().map(perso -> perso.getTipoPersonalizacionId()).collect(Collectors.toList());
    List<Optional<TipoPersonalizacion>> listaDeTipoPersonalizacion = listaDeTipoDePersonalizacionIDs.stream().map(tipo -> repoTipoPersonalizacion.findById(tipo)).collect(Collectors.toList());


    //Validamos si existe el vendedor
    if (vendedor.isPresent()) {
      //Validamos si existe el Producto Base
      if (productoBaseOptional.isPresent()) {
        //VALIDAMOS SI EXISTEN TANTO AREA COMO TIPO DE PERSONALIZACION
        if (listaDeAreas.stream().allMatch(area -> area.isPresent()) && listaDeTipoPersonalizacion.stream().allMatch(tipoPersonalizacion -> tipoPersonalizacion.isPresent())) {

          List<Personalizacion> personalizacionList = personalizacionesDTOList.stream().map(personalizacionDTO -> new Personalizacion(personalizacionDTO.getDescripcion(), personalizacionDTO.getPrecio(), repoTipoPersonalizacion.findById(personalizacionDTO.getTipoPersonalizacionId()).get(), repoArea.findById(personalizacionDTO.getAreaId()).get())).collect(Collectors.toList());
          //VALIDAMOS SI EL TIPO DE PERSO ES "COMPATIBLE" AREA
          if (productoBaseOptional.get().validarPersos(personalizacionList)) {

            ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado(productoBaseOptional.get(),vendedor.get(), personalizacionList);
            repoProductoPersonalizado.save(productoPersonalizado);
            return new ResponseEntity<Object>("El producto personalizado fue creado con éxito", HttpStatus.CREATED);

          } else
            return new ResponseEntity<Object>("El Tipo de personalizacion no es compatible con el area", HttpStatus.BAD_REQUEST);
        } else
          return new ResponseEntity<Object>("El area o el tipo de personalizacion no existen", HttpStatus.NOT_FOUND);
      } else return ResponseEntity.badRequest().body("Producto base no encontrado!");

    }
    else return new ResponseEntity<>("El vendedor no existe",HttpStatus.NOT_FOUND);
  }
}



    //boolean existe = repoProductoBase.existsById(productoPersonalizado.getProductoBase().getId());


    //VALIDACIONES

   //if(existe) {

      // 2° VALIDAR QUE LAS PERSONALIZACIONES SEAN ACEPTADAS EN LAS AREAS

     // List<Personalizacion> personalizaciones = productoPersonalizado.getPersonalizaciones();
     // boolean valid = personalizaciones.stream().allMatch(personalizacion -> productoPersonalizado.getProductoBase().validarPersonalizacion(personalizacion));

      //if (valid) {
        //repoProductoPersonalizado.save(productoPersonalizado);
        //return new ResponseEntity<Object>("Creado con exito", HttpStatus.CREATED);
     // } else {
      //  return new ResponseEntity<Object>("No es posible esa personalizacion", HttpStatus.BAD_REQUEST);
     // }
    //}

    //return new ResponseEntity<Object>("El producto base no existe", HttpStatus.NOT_FOUND);
