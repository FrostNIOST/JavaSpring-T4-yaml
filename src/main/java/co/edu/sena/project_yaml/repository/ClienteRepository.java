package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository <Cliente, String> {
}
