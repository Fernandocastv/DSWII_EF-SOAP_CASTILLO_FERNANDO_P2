package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.endpoint;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class LibroEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private ILibroService libroService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibrosRequest")
    @ResponsePayload
    public GetLibrosResponse getLibros(@RequestPayload GetLibrosRequest request){
        return libroService.buscarLibros();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibroRequest")
    @ResponsePayload
    public GetLibroResponse getLibro(@RequestPayload GetLibroRequest request){
        return libroService.buscarLibroXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putLibroRequest")
    @ResponsePayload
    public PutLibroResponse actualizarLibro(@RequestPayload PutLibroRequest request){
        return libroService.actualizarLibro(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postLibroRequest")
    @ResponsePayload
    public PostLibroResponse saveLibro(@RequestPayload PostLibroRequest request){
        return libroService.registrarLibro(request);
    }
}
