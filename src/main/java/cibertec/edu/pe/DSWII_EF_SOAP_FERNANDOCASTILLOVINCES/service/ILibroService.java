package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service;

import pe.edu.cibertec.ws.object.*;

public interface ILibroService {
    PostLibroResponse registrarLibro(PostLibroRequest request);
    PutLibroResponse actualizarLibro(PutLibroRequest request);
    GetLibrosResponse buscarLibros();
    GetLibroResponse buscarLibroXId(Integer id);
}
