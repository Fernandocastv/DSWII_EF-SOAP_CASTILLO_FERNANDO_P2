package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.util.convert;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Libro;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.ws.object.Librows;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibroConvert {

    public Libro mapearALibros(Librows librows) {
        Libro libro = new Libro();
        libro.setId(librows.getId());
        libro.setTitulo(librows.getTitulo());
        libro.setAutor(librows.getAutor());
        libro.setPrecio(librows.getPrecio());
        return libro;
    }
    public Librows mapearALibrosws(Libro libro) {
        Librows librows = new Librows();
        librows.setId(libro.getId());
        librows.setTitulo(libro.getTitulo());
        librows.setAutor(libro.getAutor());
        librows.setPrecio(libro.getPrecio());
        return librows;
    }
    public List<Libro> mapearALibroList(List<Librows> librowsList) {
        List<Libro> libroList = new ArrayList<>();
        for (Librows librows : librowsList) {
            libroList.add(mapearALibros(librows));
        }
        return libroList;
    }
    public List<Librows> mapearALibrowsList(List<Libro> libroList) {
        List<Librows> librowsList = new ArrayList<>();
        for (Libro libro : libroList) {
            librowsList.add(mapearALibrosws(libro));
        }
        return librowsList;
    }

}
