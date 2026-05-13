package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;
    @DataMongoTest

class TipoDocumentoRepositoryTest {

        @Autowired
        private TipoDocumentoRepository tipoDocumentoRepository;
        @Autowired
        private MongoTemplate mongoTemplate;

        @Test
    @Order(1)
        void insert(){
        mongoTemplate.dropCollection(TipoDocumento.class);
        //tipoDocumentoRepository.save(new TipoDocumento(null,"CC","Cedula de cuidadania", Estado.ACTIVO));
        TipoDocumento tipoDocumento = new TipoDocumento(null,"CC","Cedula de cuidadania", Estado.ACTIVO);
        assertNotNull(tipoDocumento);
        TipoDocumento tipoDocumentoGuardado = tipoDocumentoRepository.insert(tipoDocumento);
        assertNotNull(tipoDocumentoGuardado.getNombreDocumento());
        assertNotNull(tipoDocumentoGuardado.getSiglas());
        assertEquals("CC", tipoDocumentoGuardado.getSiglas());

    }



}