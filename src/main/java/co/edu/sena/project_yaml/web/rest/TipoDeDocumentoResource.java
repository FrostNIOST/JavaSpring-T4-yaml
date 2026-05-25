package co.edu.sena.project_yaml.web.rest;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;
import co.edu.sena.project_yaml.services.dto.TipoDocumentoDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.edu.sena.project_yaml.services.TipoDocumentoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")


public class TipoDeDocumentoResource {


    private static final Logger LOG = LoggerFactory.getLogger(TipoDeDocumentoResource.class);
    private final TipoDocumentoService tipoDocumentoService;

    public TipoDeDocumentoResource(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @PostMapping("/tipo-documento")
    public ResponseEntity<TipoDocumentoDTO> createTipoDocumento(@RequestBody TipoDocumentoDTO tipoDocumentoDTO)throws URISyntaxException {
        LOG.debug("se crea: {}", tipoDocumentoDTO);
        if (tipoDocumentoDTO.getId() != null){
            return ResponseEntity.badRequest().build();
        }else{
            TipoDocumentoDTO tipoDocumentoGuardado = tipoDocumentoService.save(tipoDocumentoDTO);
            return ResponseEntity.created(new URI("api/tipo-documento" + tipoDocumentoGuardado.getId())).body(tipoDocumentoGuardado);
        }

    }

    @PutMapping("/tipo-documento/{id}")
    public ResponseEntity<TipoDocumentoDTO> updateTipoDocumento (@PathVariable(value = "id", required = false) final String id, @RequestBody TipoDocumentoDTO tipoDocumentoDTO){
        LOG.debug("se actualiza: {}", tipoDocumentoDTO);
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
        if(!tipoDocumentoDTO.getId().equals(id)){
            System.out.println(id);
            System.out.println(tipoDocumentoDTO.getId());
            return ResponseEntity.badRequest().build();
        }
        Optional<TipoDocumentoDTO> tipoDocumentoDTOOptional = tipoDocumentoService.findOne(id);
        if (tipoDocumentoDTOOptional.isPresent()){
            TipoDocumentoDTO tipoDocumentoGuardado = tipoDocumentoService.update(tipoDocumentoDTO);
            return ResponseEntity.ok().body(tipoDocumentoGuardado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping ("/tipo-documento")
    public ResponseEntity<List<TipoDocumentoDTO>> getTipoDocumento(){
        List<TipoDocumentoDTO> tipoDocumentoDTOS = tipoDocumentoService.findAll();
        LOG.debug("se obtiene: {}", tipoDocumentoDTOS);
        return ResponseEntity.ok().body(tipoDocumentoDTOS);
    }

    @GetMapping("/tipo-documento/{id}")
    public ResponseEntity<TipoDocumentoDTO> getTipoDocumentoById(@PathVariable("id") String id){
        LOG.debug("Obteniendo el id: {}", id);
        if (id == null){
            return ResponseEntity.notFound().build();
        }else {
            Optional<TipoDocumentoDTO> tipoDocumentoDTO = tipoDocumentoService.findOne(id);
            return tipoDocumentoDTO.map(documento -> ResponseEntity.ok().body(documento)).orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

    @DeleteMapping("/tipo-documento/{id}")
    public ResponseEntity<Void> deleteTipoDocumentoById(@PathVariable(value = "id", required = false)final String id, TipoDocumentoDTO tipoDocumentoDTO){
        LOG.debug("Se eliminó: {}", tipoDocumentoDTO);
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        if (!tipoDocumentoDTO.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Optional<TipoDocumentoDTO> tipoDocumentoAEliminar = tipoDocumentoService.findOne(id);
        if(tipoDocumentoAEliminar.isEmpty()){
            return ResponseEntity.badRequest().build();
        }else{
            tipoDocumentoService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

}
