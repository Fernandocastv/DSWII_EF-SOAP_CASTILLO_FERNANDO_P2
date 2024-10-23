package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.endpoint;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class CategoriaEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private ICategoriaService categoriaService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriasRequest")
    @ResponsePayload
    public GetCategoriasResponse getCategorias(@RequestPayload GetCategoriasRequest request){
        return categoriaService.buscarCategorias();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriaRequest")
    @ResponsePayload
    public GetCategoriaResponse getCategoria(@RequestPayload GetCategoriaRequest request){
        return categoriaService.buscarCategoriaXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putCategoriaRequest")
    @ResponsePayload
    public PutCategoriaResponse actualizarCategoria(@RequestPayload PutCategoriaRequest request){
        return categoriaService.actualizarCategoria(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCategoriaRequest")
    @ResponsePayload
    public PostCategoriaResponse saveCategoria(@RequestPayload PostCategoriaRequest request){
        return categoriaService.registrarCategoria(request);
    }
}
