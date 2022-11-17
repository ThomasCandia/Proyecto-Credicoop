package domain;

import domain.model.entities.producto.Area;
import domain.model.entities.producto.ProductoBase;
import domain.model.entities.vendedor.MetodoDePago;
import domain.model.entities.vendedor.Vendedor;
import domain.repositories.RepoProductoBase;
import domain.repositories.RepoVendedor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
  public class AppCredicooop {

  public static void main(String[] args) {
    SpringApplication.run(AppCredicooop.class, args);
  }

  @Bean
  public CommandLineRunner ejemplo() {
      return (args) -> {

        // METODOS DE PAGO

        //MetodoDePago efectivo = new MetodoDePago("Efectivo");
        //MetodoDePago tarjetaDebito = new MetodoDePago("Tarjeta de Débito");
        //MetodoDePago tarjetaCredito = new MetodoDePago("Tarjeta de Credito");


        /*
        ProductoBase remera1 = new ProductoBase("Remera", 12.68,"negra","2 meses");
        ProductoBase buzo = new ProductoBase("Buzo", 12.68,"negra","2 meses");
        remera1.agregarArea(area1);
        buzo.agregarArea(area2);
        repo.save(remera1);
        repo.save(buzo);
        ProductoBase buzoBuscado = repo.findProductoBaseByNombre("Buzo");


        */


      };
  }

}



