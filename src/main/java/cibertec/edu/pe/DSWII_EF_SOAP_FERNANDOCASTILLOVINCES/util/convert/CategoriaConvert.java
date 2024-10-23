package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.util.convert;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Categoria;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.ws.object.Categoriaws;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConvert {

    public Categoria mapearACategoria(Categoriaws categoriaws){
        Categoria categoria = new Categoria();
        categoriaws.setId(categoriaws.getId());
        categoria.setNombre(categoriaws.getNombre());
        categoria.setDescripcion(categoriaws.getDescripcion());
        return categoria;
    }
    public Categoriaws mapearACategoriaws(Categoria categoria){
        Categoriaws categoriaws = new Categoriaws();
        categoriaws.setId(categoria.getId());
        categoriaws.setNombre(categoria.getNombre());
        categoriaws.setDescripcion(categoria.getDescripcion());
        return categoriaws;
    }
    public List<Categoria> mapearACategoriaList(List<Categoriaws> categoriawsList){
        List<Categoria> categoriaList = new ArrayList<>();
        for(Categoriaws categoriaws : categoriawsList){
            categoriaList.add(mapearACategoria(categoriaws));
        }
        return categoriaList;
    }
    public List<Categoriaws> mapearACategoriawsList(List<Categoria> categoriaList){
        List<Categoriaws> CategoriawsList = new ArrayList<>();
        for(Categoria categoria : categoriaList){
            CategoriawsList.add(mapearACategoriaws(categoria));
        }
        return CategoriawsList;
    }

}
