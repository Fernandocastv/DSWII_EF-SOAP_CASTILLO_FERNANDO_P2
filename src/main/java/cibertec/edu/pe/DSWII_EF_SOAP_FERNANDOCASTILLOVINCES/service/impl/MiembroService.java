package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.impl;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.exception.NotFoundException;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Miembro;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.repository.MiembroRepository;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.IMiembroService;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.util.convert.MiembroConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class MiembroService implements IMiembroService {
    private final MiembroRepository miembroRepository;
    private final MiembroConvert miembroConvert;

    @Override
    public PostMiembroResponse registrarMiembro(PostMiembroRequest request) {
        PostMiembroResponse postMiembroResponse = new PostMiembroResponse();
        Miembro nuevoMiembro = miembroRepository.save(
                miembroConvert.mapearAMiembro(request.getMiembro())
        );
        postMiembroResponse.setMiembro(
                miembroConvert.mapearAMiembrows(nuevoMiembro)
        );
        return postMiembroResponse;    }

    @Override
    public PutMiembroResponse actualizarMiembro(PutMiembroRequest request) {
        PutMiembroResponse putMiembroResponse = new PutMiembroResponse();
        Miembro miembro = miembroRepository.findById(request.getMiembro().getId()).orElse(null);
        if(miembro ==null) {
            throw new NotFoundException("Miembro con el ID " + request.getMiembro().getId() + " no encontrado");
        }else {
            putMiembroResponse.setMiembro(
                    miembroConvert.mapearAMiembrows(miembroRepository.save(
                            miembroConvert.mapearAMiembro(request.getMiembro())
                    ))
            );
        }
        return putMiembroResponse;    }

    @Override
    public GetMiembrosResponse buscarMiembros() {
        GetMiembrosResponse getMiembrosResponse = new GetMiembrosResponse();
        getMiembrosResponse.getMiembros().addAll(
                miembroConvert.mapearAMiembrowsList(miembroRepository.findAll())
        );
        return getMiembrosResponse;    }

    @Override
    public GetMiembroResponse buscarMiembroXId(Integer id) {
        GetMiembroResponse getMiembroResponse = new GetMiembroResponse();
        Miembro miembro = miembroRepository.findById(id).orElse(null);
        if(miembro==null){
            throw new NotFoundException("Miembro con el ID "+id+" no encontrado");
        }else{
            getMiembroResponse.setMiembro(
                    miembroConvert.mapearAMiembrows(miembro)
            );
        }

        return getMiembroResponse;    }
}
