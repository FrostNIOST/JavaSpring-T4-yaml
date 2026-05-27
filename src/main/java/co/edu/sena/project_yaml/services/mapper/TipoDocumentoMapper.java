package co.edu.sena.project_yaml.services.mapper;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.services.dto.TipoDocumentoDTO;
import com.mongodb.internal.logging.LogMessage;
import org.mapstruct.Mapper;

import javax.swing.*;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper extends EntityMapper<TipoDocumentoDTO, TipoDocumento>{
    TipoDocumento toEntity (TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumentoDTO toDto (TipoDocumento tipoDocumento);
    List<TipoDocumentoDTO> toDto(List<TipoDocumento> tipoDocumentos);
}
