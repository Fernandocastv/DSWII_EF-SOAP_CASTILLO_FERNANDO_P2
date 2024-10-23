package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DetallePrestamo")
public class DetallePrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idprestamo", nullable = false)
    private Prestamo prestamo;

    @ManyToOne
    @JoinColumn(name = "idlibro", nullable = false)
    private Libro libro;

    private String instrucciones;

}
