package co.edu.sena.project_yaml.services;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;
import co.edu.sena.project_yaml.services.dto.TipoDocumentoDTO;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoService {
    TipoDocumentoDTO save(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumentoDTO update(TipoDocumentoDTO tipoDocumentoDTO);
    Optional<TipoDocumentoDTO> findOne(String id);
    List<TipoDocumentoDTO> findAll();
    void delete(String id);
}
