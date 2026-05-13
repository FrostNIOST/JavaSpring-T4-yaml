package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository <Cuenta, String> {
}
