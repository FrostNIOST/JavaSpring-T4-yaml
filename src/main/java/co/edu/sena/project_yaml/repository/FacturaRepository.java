package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacturaRepository  extends MongoRepository <Factura, String> {
}
