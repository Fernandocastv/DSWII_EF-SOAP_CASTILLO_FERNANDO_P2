package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service;

import pe.edu.cibertec.ws.object.*;

public interface ICategoriaService {
    PostCategoriaResponse registrarCategoria(PostCategoriaRequest request);
    PutCategoriaResponse actualizarCategoria(PutCategoriaRequest request);
    GetCategoriasResponse buscarCategorias();
    GetCategoriaResponse buscarCategoriaXId(Integer id);
}
