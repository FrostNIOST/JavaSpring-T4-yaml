package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import co.edu.sena.project_yaml.domain.TipoDocumento;
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
        //clienteRepository.save(new Cliente(null, "5661561845", "Andrea", "Mar", "Perez", "Perez"));
        Cliente cliente = new Cliente(null, "5661561845", "Andrea", "Mar", "Perez", "Perez");

        TipoDocumento tipoDocumentoCedula = tipoDocumentoRepository.findBySiglas("CC").orElse(null);
        assertNotNull(tipoDocumentoCedula);

        cliente.setTipoDocumento(tipoDocumentoCedula);

        clienteRepository.insert(cliente);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado.getId());
        Cliente clienteTest = clienteRepository.findById(clienteGuardado.getId()).orElse(null);
        assertEquals(clienteGuardado.getId(), clienteTest.getId());
        assertEquals("5661561845", clienteTest.getNumeroDocumento());
    }

}