package domain.repositories;

import domain.model.entities.producto.ProductoBase;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;


public class RepoProductoBase implements WithGlobalEntityManager {


  public void cargarProductoBase(ProductoBase productoBase){

    entityManager().persist(productoBase);
  }

  //TODO
  /*
  @SuppressWarnings("unchecked")
  public List<ProductoBase> getProductos(){
    return entityManager().createQuery("from ")
  }*/

}

