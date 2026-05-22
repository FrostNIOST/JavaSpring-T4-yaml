package co.edu.sena.project_yaml.services;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoService {
    TipoDocumento save(TipoDocumento tipoDocumento);
    TipoDocumento update(TipoDocumento tipoDocumento);
    Optional<TipoDocumento> findOne(String id);
    List<TipoDocumento> findAll();
    void delete(String id);
}
