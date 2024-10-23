package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service;

import pe.edu.cibertec.ws.object.*;

public interface IMiembroService {
    PostMiembroResponse registrarMiembro(PostMiembroRequest request);
    PutMiembroResponse actualizarMiembro(PutMiembroRequest request);
    GetMiembrosResponse buscarMiembros();
    GetMiembroResponse buscarMiembroXId(Integer id);
}
