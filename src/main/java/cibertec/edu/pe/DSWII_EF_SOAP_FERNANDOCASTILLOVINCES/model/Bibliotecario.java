package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Bibliotecario")
public class Bibliotecario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;
    private String telefono;
    private String correo;
}
