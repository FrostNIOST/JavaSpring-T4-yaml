package co.edu.sena.project_yaml.web.rest;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")


public class TipoDeDocumentoResource {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    private static final Logger LOG = LoggerFactory.getLogger(TipoDeDocumentoResource.class);

    public TipoDeDocumentoResource(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @PostMapping("/tipo-documento")
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento)throws URISyntaxException {
        LOG.debug("se crea: {}", tipoDocumento);
        if (tipoDocumento.getId() != null){
            return ResponseEntity.badRequest().build();
        }else{
            TipoDocumento tipoDocumentoGuardado = tipoDocumentoRepository.insert(tipoDocumento);
            return ResponseEntity.created(new URI("api/tipo-documento" + tipoDocumentoGuardado.getId())).body(tipoDocumentoGuardado);
        }

    }

    @PutMapping("/tipo-documento/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento (@PathVariable(value = "id", required = false) final String id, @RequestBody TipoDocumento tipoDocumento){
        LOG.debug("se actualiza: {}", tipoDocumento);
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
        if(!tipoDocumento.getId().equals(id)){
            System.out.println(id);
            System.out.println(tipoDocumento.getId());
            return ResponseEntity.badRequest().build();
        }
        Optional<TipoDocumento> tipoDocumentoUpdated = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoUpdated.isPresent()){
            TipoDocumento tipoDocumentoGuardado = tipoDocumentoRepository.save(tipoDocumento);
            return ResponseEntity.ok().body(tipoDocumentoGuardado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping ("/tipo-documento")
    public ResponseEntity<List<TipoDocumento>> getTipoDocumento(){
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        return ResponseEntity.ok().body(tipoDocumentos);
    }

    @GetMapping("/tipo-documento/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable("id") String id){
        if (id == null){
            return ResponseEntity.notFound().build();
        }else {
            Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findById(id);
            return tipoDocumento.map(documento -> ResponseEntity.ok().body(documento)).orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

    @DeleteMapping("/tipo-documento/{id}")
    public ResponseEntity<Void> deleteTipoDocumentoById(@PathVariable(value = "id", required = false)final String id, TipoDocumento tipoDocumento){
        LOG.debug("Se eliminó: {}", tipoDocumento);
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        if (!tipoDocumento.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        Optional<TipoDocumento> tipoDocumentoAEliminar = tipoDocumentoRepository.findById(id);
        if(tipoDocumentoAEliminar.isEmpty()){
            return ResponseEntity.badRequest().build();
        }else{
            tipoDocumentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

}
