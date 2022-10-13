package domain;

import domain.model.entities.producto.Area;
import domain.repositories.RepoProductoBase;
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
  public CommandLineRunner ejemplo(RepoProductoBase repo) {
      return (args) -> {

       /* Area area1 = new Area("atras");
        Area area2 = new Area("atras");
        ProductoBase remera1 = new ProductoBase("Remera", 12.68,"negra","2 meses");
        ProductoBase buzo = new ProductoBase("Buzo", 12.68,"negra","2 meses");
        remera1.agregarArea(area1);
        buzo.agregarArea(area2);
        repo.save(remera1);
        repo.save(buzo);
        ProductoBase buzoBuscado = repo.findProductoBaseByNombre("Buzo");


        */

       // Vendedor vendedor1 = new Vendedor(new Tienda());
        //repo3.save(vendedor1);
      };
  }

}



