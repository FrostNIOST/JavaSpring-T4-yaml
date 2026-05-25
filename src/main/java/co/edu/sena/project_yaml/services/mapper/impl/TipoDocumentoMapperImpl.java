package co.edu.sena.project_yaml.services.mapper.impl;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.services.dto.TipoDocumentoDTO;
import co.edu.sena.project_yaml.services.mapper.TipoDocumentoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {

    public TipoDocumento toEntity(TipoDocumentoDTO tipoDocumentoDTO){
        if (tipoDocumentoDTO == null) return null;
        TipoDocumento entity = new TipoDocumento();
        entity.setId(tipoDocumentoDTO.getId());
        entity.setSiglas(tipoDocumentoDTO.getSigla());
        entity.setNombreDocumento(tipoDocumentoDTO.getNombreDocumento());
        entity.setEstado(tipoDocumentoDTO.getEstado());
        return entity;
    }

    public TipoDocumentoDTO toDto (TipoDocumento tipoDocumento){
        if(tipoDocumento == null) return null;
        TipoDocumentoDTO toDto = new TipoDocumentoDTO();
        toDto.setId(tipoDocumento.getId());
        toDto.setSigla(tipoDocumento.getSiglas());
        toDto.setNombreDocumento(tipoDocumento.getNombreDocumento());
        toDto.setEstado(tipoDocumento.getEstado());
        return toDto;
    }


    public List<TipoDocumentoDTO> toDto (List<TipoDocumento> tipoDocumentos){
        if (tipoDocumentos == null) return Collections.emptyList();
        List<TipoDocumentoDTO> dtos = new ArrayList<>();
            for (TipoDocumento tipoDocumento : tipoDocumentos){
                dtos.add(toDto(tipoDocumento));
            }
            return dtos;

    }



}
