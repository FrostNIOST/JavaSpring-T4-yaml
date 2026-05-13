package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.Cliente;
import co.edu.sena.project_yaml.domain.Cuenta;
import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CuentaRepositoryTest {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    @Order(1)
    void insert(){
        mongoTemplate.dropCollection(Cliente.class);
        mongoTemplate.dropCollection(Cuenta.class);
        tipoDocumentoRepository.deleteAll();

        TipoDocumento tipoDocumentoCedula = tipoDocumentoRepository.insert(new TipoDocumento(null, "CC", "Cedula de ciudadania", Estado.ACTIVO));
        assertNotNull(tipoDocumentoCedula);

        Cliente cliente = new Cliente(null, "2536089423", "clienteName1", "clinteName2", "clienteName3", "clienteName4");
        Cliente cliente2 = new Cliente(null, "2536089424", "clienteName1", "clinteName2", "clienteName3", "clienteName4");

        cliente.setTipoDocumento(tipoDocumentoCedula);
        cliente2.setTipoDocumento(tipoDocumentoCedula);

        Cliente clienteGuardado = clienteRepository.insert(cliente);
        Cliente clienteGuardado2 = clienteRepository.insert(cliente2);

        Cuenta cuentaFacebook = new Cuenta(null, "nick en facebook");
        Cuenta cuentaX = new Cuenta(null, "nickname X");

        cuentaFacebook.setEstado(Estado.ACTIVO);
        cuentaX.setEstado(Estado.INACTIVO);

        cuentaFacebook.setCliente(clienteGuardado);
        cuentaX.setCliente(clienteGuardado2);

        Cuenta cuentaGuardada1 = cuentaRepository.insert(cuentaFacebook);
        Cuenta cuentaGuardada2 = cuentaRepository.insert(cuentaX);

        assertNotNull(cuentaGuardada1.getId());
        assertNotNull(cuentaGuardada2.getId());
        assertNotNull(cuentaGuardada1.getCliente());
        assertNotNull(cuentaGuardada2.getCliente());
        assertEquals("nick en facebook", cuentaGuardada1.getNickname());
        assertEquals("nickname X", cuentaGuardada2.getNickname());
        assertEquals(2, cuentaRepository.count());

    }


}