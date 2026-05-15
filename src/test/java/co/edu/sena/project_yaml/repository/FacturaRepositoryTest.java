package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import co.edu.sena.project_yaml.domain.Factura;
import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.domain.TipoDocumentoEmbedded;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class FacturaRepositoryTest {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;


    @Test
    @Order(1)
    void insert(){
        facturaRepository.deleteAll();
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

        Factura factura1 = new Factura(null, 1L, 2026, new Date(), 20000.0, 3800, 16200);
        Factura factura2 = new Factura(null, 2L, 2026, new Date(), 20000.0, 3800, 16200);
        Factura factura3 = new Factura(null, 3L, 2026, new Date(), 20000.0, 3800, 16200);
        Factura factura4 = new Factura(null, 4L, 2026, new Date(), 20000.0, 3800, 16200);

        clienteGuardado.getFacturaSet().add(factura1);
        clienteGuardado.getFacturaSet().add(factura2);
        clienteGuardado.getFacturaSet().add(factura3);
        clienteGuardado.getFacturaSet().add(factura4);

        facturaRepository.insert(factura1);
        facturaRepository.insert(factura2);
        facturaRepository.insert(factura3);
        facturaRepository.insert(factura4);

        clienteRepository.save(clienteGuardado);




    }

}