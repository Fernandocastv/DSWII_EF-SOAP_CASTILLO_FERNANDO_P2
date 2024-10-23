package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.endpoint;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.IMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class MiembroEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IMiembroService miembroService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMiembrosRequest")
    @ResponsePayload
    public GetMiembrosResponse getMiembros(@RequestPayload GetMiembrosRequest request){
        return miembroService.buscarMiembros();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMiembroRequest")
    @ResponsePayload
    public GetMiembroResponse getMiembro(@RequestPayload GetMiembroRequest request){
        return miembroService.buscarMiembroXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putMiembroRequest")
    @ResponsePayload
    public PutMiembroResponse actualizarMiembro(@RequestPayload PutMiembroRequest request){
        return miembroService.actualizarMiembro(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMiembroRequest")
    @ResponsePayload
    public PostMiembroResponse saveMiembro(@RequestPayload PostMiembroRequest request){
        return miembroService.registrarMiembro(request);
    }


}
