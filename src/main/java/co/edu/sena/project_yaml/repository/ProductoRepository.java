package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository <Producto, String> {
}
