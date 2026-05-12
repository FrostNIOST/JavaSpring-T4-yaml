package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Test
    @Order(1)

    void insert(){
        Cliente cliente = new Cliente(null, "5661561845", "Andrea", "Mar", "Perez", "Perez");
        
        clienteRepository.insert(cliente);
    }

}