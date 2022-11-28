package domain;

import domain.model.entities.comprador.Comprador;
import domain.model.entities.producto.Area;
import domain.model.entities.producto.ProductoBase;
import domain.model.entities.producto.TipoPersonalizacion;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
  public class AppCredicooop {

  public static void main(String[] args) {
    SpringApplication.run(AppCredicooop.class, args);
  }

  @Bean
  public CommandLineRunner ejemplo(RepoMetodoDePago repoMetodoDePago, RepoArea repoArea,
                                   RepoTipoPersonalizacion repoTipoPersonalizacion, RepoComprador repoComprador,
                                   RepoVendedor repoVendedor) {
      return (args) -> {

        Optional<MetodoDePago> baseDeDatosLlena = repoMetodoDePago.findById(1);

        if (!baseDeDatosLlena.isPresent()){

          // METODOS DE PAGO

          MetodoDePago efectivo = new MetodoDePago("Efectivo");
          MetodoDePago tarjetaDebito = new MetodoDePago("Tarjeta de Débito");
          MetodoDePago tarjetaCredito = new MetodoDePago("Tarjeta de Credito");

          repoMetodoDePago.save(efectivo);
          repoMetodoDePago.save(tarjetaDebito);
          repoMetodoDePago.save(tarjetaCredito);

          // AREAS

          Area frente = new Area("Frente");
          Area espalda = new Area("Trasera");
          Area arriba = new Area("Parte de arriba");
          Area abajo = new Area("Parte de abajo");

          repoArea.save(frente);
          repoArea.save(espalda);
          repoArea.save(arriba);
          repoArea.save(abajo);

          // TIPOS DE PERSONALIZACION

          TipoPersonalizacion foto = new TipoPersonalizacion("Foto");
          TipoPersonalizacion emoji = new TipoPersonalizacion("Emoji");
          TipoPersonalizacion texto = new TipoPersonalizacion("Texto");
          TipoPersonalizacion imagenBlancoYNegro = new TipoPersonalizacion("Imagen blanco y negro");
          TipoPersonalizacion imagenAColor = new TipoPersonalizacion("Imagen a color");

          repoTipoPersonalizacion.save(foto);
          repoTipoPersonalizacion.save(emoji);
          repoTipoPersonalizacion.save(texto);
          repoTipoPersonalizacion.save(imagenBlancoYNegro);
          repoTipoPersonalizacion.save(imagenAColor);

          // COMPRADORES

          Comprador comprador1 = new Comprador("Thomas");
          Comprador comprador2 = new Comprador("Lisandro");

          repoComprador.save(comprador1);
          repoComprador.save(comprador2);

          // VENDEDORES

          List<MetodoDePago> metodoDePagosAceptados1 = new ArrayList<>();
          metodoDePagosAceptados1.add(efectivo);
          metodoDePagosAceptados1.add(tarjetaCredito);

          List<MetodoDePago> metodoDePagosAceptados2 = new ArrayList<>();
          metodoDePagosAceptados1.add(efectivo);
          metodoDePagosAceptados1.add(tarjetaDebito);

          Vendedor vendedor1 = new Vendedor("Lucas","Martinez",metodoDePagosAceptados1);
          Vendedor vendedor2 = new Vendedor("Ricardo","Gutierrez",metodoDePagosAceptados2);

          repoVendedor.save(vendedor1);
          repoVendedor.save(vendedor2);


        }

      };
  }

}



