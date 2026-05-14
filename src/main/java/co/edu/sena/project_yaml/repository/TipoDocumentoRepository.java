package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TipoDocumentoRepository extends MongoRepository<TipoDocumento, String> {

    Optional<TipoDocumento> findBySiglas(String sigla);
}
