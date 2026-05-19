package co.edu.sena.project_yaml.web.rest;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.repository.TipoDocumentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")


public class TipoDeDocumentoResource {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDeDocumentoResource(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @PostMapping("/tipo-documento")
    public String createTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
        tipoDocumentoRepository.save(tipoDocumento);
        System.out.println("Se crea: " + tipoDocumento.toString());
        return "Crear tipo documento";
    }

    @PutMapping("/tipo-documento")
    public String updateTipoDocumento (@RequestBody TipoDocumento tipoDocumento){
        System.out.println("Se actualiza: " + tipoDocumento.toString());
        return "Actualizar tipo documento";
    }

    @GetMapping ("/tipo-documento")
    public ResponseEntity<List<TipoDocumento>> getTipoDocumento(){
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        return ResponseEntity.ok().body(tipoDocumentos);
    }

    @GetMapping("/tipo-documento/{id}")
    public String getTipoDocumentoById(@PathVariable("id") String id){
        return "Getting document by id: "+ id;
    }

    @DeleteMapping("/tipo-documento/{id}")
    public String deleteTipoDocumentoById(@PathVariable("id")String id){
        return "Deleting document by id: "+ id;
    }

}
