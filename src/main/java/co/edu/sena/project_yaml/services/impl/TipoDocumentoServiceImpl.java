package co.edu.sena.project_yaml.services.impl;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;
import co.edu.sena.project_yaml.services.TipoDocumentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoServiceImpl(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @Override
    public TipoDocumento save(TipoDocumento tipoDocumento){
        return tipoDocumento.insert(tipoDocumento);
    }

    @Override
    public TipoDocumento update(TipoDocumento tipoDocumento){
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public Optional <TipoDocumento> findOne(String id){
        return tipoDocumentoRepository.findById(id);
    }

    public List<TipoDocumento> findAll(){
        return tipoDocumentoRepository.findAll();
    }

}
