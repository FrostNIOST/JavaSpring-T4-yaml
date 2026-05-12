package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.TipoDocumento;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.core.annotation.Order;

import static org.junit.jupiter.api.Assertions.*;
    @DataMongoTest

class TipoDocumentoRepositoryTest {

        @Autowired
        private TipoDocumentoRepository tipoDocumentoRepository;

    @Test
    @Order(1)
        void insert(){
        tipoDocumentoRepository.save(new TipoDocumento(null,"CC","Cedula de cuidadania", Estado.ACTIVO));


    }



}