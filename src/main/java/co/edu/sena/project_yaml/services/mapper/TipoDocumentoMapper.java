package co.edu.sena.project_yaml.services.mapper;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.services.dto.TipoDocumentoDTO;

import java.util.List;

public interface TipoDocumentoMapper {
    TipoDocumento toEntity (TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumentoDTO toDto (TipoDocumento tipoDocumento);
    List<TipoDocumentoDTO> toDto(List<TipoDocumento> tipoDocumentos);
}
