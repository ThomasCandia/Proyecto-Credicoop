package domain;

import domain.model.entities.producto.ProductoBase;
import domain.repositories.RepoProductoBaseSpring;
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
  public CommandLineRunner ejemplo(RepoProductoBaseSpring repo){
      return (args) -> {
        repo.save(new ProductoBase("buzo", 13,"blanca","10 dias"));
      };
  }

}



