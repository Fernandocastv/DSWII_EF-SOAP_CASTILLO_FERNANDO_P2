package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Prestamo")
@Getter
@Setter
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "idmiembro", nullable = false)
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "idlibro", nullable = false)
    private Libro libro;
}
