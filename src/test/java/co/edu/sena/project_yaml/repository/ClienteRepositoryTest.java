package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.domain.TipoDocumentoEmbedded;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
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
        clienteRepository.deleteAll();
        tipoDocumentoRepository.deleteAll();

        TipoDocumento tipoDocumentoCedula = new TipoDocumento(null, "CC", "Cedula de cuidadania", Estado.ACTIVO);
        TipoDocumento tipoDocumentoGuardado = tipoDocumentoRepository.insert(tipoDocumentoCedula);
        assertEquals("CC", tipoDocumentoGuardado.getSiglas());
        assertNotNull(tipoDocumentoCedula);

        Cliente cliente = new Cliente(null, "5661561845", "Andrea", "Mar", "Perez", "Perez");
        Cliente cliente1 = new Cliente(null, "5661561846", "Andrea", "Mar", "Perez", "Perez");

        TipoDocumentoEmbedded tipoDocumentoEmbedded = new TipoDocumentoEmbedded(tipoDocumentoCedula.getSiglas(), tipoDocumentoCedula.getNombreDocumento());

        cliente.setTipoDocumentoEmbedded(tipoDocumentoEmbedded);
        cliente1.setTipoDocumentoEmbedded(tipoDocumentoEmbedded);

        clienteRepository.insert(cliente);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        Cliente cliente1Guardado = clienteRepository.save(cliente1);
        assertNotNull(clienteGuardado.getId());
        assertNotNull(cliente1Guardado.getId());
        assertEquals("CC", clienteGuardado.getTipoDocumentoEmbedded().getSigla());
        assertEquals("CC", cliente1Guardado.getTipoDocumentoEmbedded().getSigla());



        /*
        assertNotNull(clienteGuardado.getId());
        Cliente clienteTest = clienteRepository.findById(clienteGuardado.getId()).orElse(null);
        assertEquals(clienteGuardado.getId(), clienteTest.getId());
        assertEquals("5661561845", clienteTest.getNumeroDocumento());

         */
    }

}