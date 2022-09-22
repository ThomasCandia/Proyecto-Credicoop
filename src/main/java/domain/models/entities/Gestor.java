package domain.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Gestor")
@Setter @Getter
public class Gestor extends Persistente {

  @Column(name = "nombre")
  private String nombre;
}
