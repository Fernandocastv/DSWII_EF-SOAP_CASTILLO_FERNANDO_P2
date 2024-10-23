package cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.impl;

import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.exception.NotFoundException;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.model.Categoria;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.repository.CategoriaRepository;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.service.ICategoriaService;
import cibertec.edu.pe.DSWII_EF_SOAP_FERNANDOCASTILLOVINCES.util.convert.CategoriaConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ws.object.*;


@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaConvert categoriaConvert;

    @Override
    public PostCategoriaResponse registrarCategoria(PostCategoriaRequest request) {
        PostCategoriaResponse postCategoriaResponse = new PostCategoriaResponse();
        Categoria nuevaCategoria = categoriaRepository.save(
                categoriaConvert.mapearACategoria(request.getCategoria())
        );
        postCategoriaResponse.setCategoria(
                categoriaConvert.mapearACategoriaws(nuevaCategoria)
        );
        return postCategoriaResponse;    }

    @Override
    public PutCategoriaResponse actualizarCategoria(PutCategoriaRequest request) {
        PutCategoriaResponse putCategoriaResponse = new PutCategoriaResponse();
        Categoria especialidad = categoriaRepository.findById(request.getCategoria().getId()).orElse(null);
        if(especialidad == null){
            throw new NotFoundException("Categoria con el ID "+request.getCategoria().getId()+" no encontrado");
        }else {
            putCategoriaResponse.setCategoria(
                    categoriaConvert.mapearACategoriaws(categoriaRepository.save(
                            categoriaConvert.mapearACategoria(request.getCategoria())
                    ))
            );
        }
        return putCategoriaResponse;    }

    @Override
    public GetCategoriasResponse buscarCategorias() {
        GetCategoriasResponse getCategoriasResponse = new GetCategoriasResponse();
        getCategoriasResponse.getCategorias().addAll(
                categoriaConvert.mapearACategoriawsList(categoriaRepository.findAll())
        );
        return getCategoriasResponse;
    }

    @Override
    public GetCategoriaResponse buscarCategoriaXId(Integer id) {
        GetCategoriaResponse getCategoriaResponse = new GetCategoriaResponse();
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria==null){
            throw new NotFoundException("Categoria con el ID "+id+" no encontrado");
        }else {
            getCategoriaResponse.setCategoria(
                    categoriaConvert.mapearACategoriaws(categoria)
            );
        }
        return getCategoriaResponse;    }
}
