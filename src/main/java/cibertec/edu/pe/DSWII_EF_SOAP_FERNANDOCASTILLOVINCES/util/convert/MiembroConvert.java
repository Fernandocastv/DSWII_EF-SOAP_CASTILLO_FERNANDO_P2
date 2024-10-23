package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.util.convert;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Miembro;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.ws.object.Miembrows;

import java.util.ArrayList;
import java.util.List;

@Component
public class MiembroConvert {

    public Miembro mapearAMiembro(Miembrows miembrows){
        Miembro miembro = new Miembro();
        miembro.setId(miembrows.getId());
        miembro.setNombre(miembrows.getNombre());
        miembro.setDireccion(miembrows.getDireccion());
        miembro.setTelefono(miembrows.getTelefono());
        miembro.setFechanacimiento(miembrows.getFechanacimiento());
        return miembro;
    }
    public Miembrows mapearAMiembrows(Miembro miembro){
        Miembrows miembrows = new Miembrows();
        miembrows.setId(miembro.getId());
        miembrows.setNombre(miembro.getNombre());
        miembrows.setDireccion(miembro.getDireccion());
        miembrows.setTelefono(miembro.getTelefono());
        miembrows.setFechanacimiento(miembro.getFechanacimiento());
        return miembrows;
    }

    public List<Miembro> mapearAMiembroList(List<Miembrows> miembrowsList){
        List<Miembro> miembroList = new ArrayList<>();
        for(Miembrows miembrows : miembrowsList){
            miembroList.add(mapearAMiembro(miembrows));
        }
        return miembroList;
    }

    public List<Miembrows> mapearAMiembrowsList(List<Miembro> miembroList){
        List<Miembrows> miembrowsList = new ArrayList<>();
        for(Miembro miembro : miembroList){
            miembrowsList.add(mapearAMiembrows(miembro));
        }
        return miembrowsList;
    }
}
