package domain.models.entities.personas;

import javax.persistence.*;

@Entity
@Table(name = "prestador")
public class Prestador {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
}
