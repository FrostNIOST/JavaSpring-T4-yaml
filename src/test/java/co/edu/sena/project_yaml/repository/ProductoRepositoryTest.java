package co.edu.sena.project_yaml.repository;

import co.edu.sena.project_yaml.domain.*;
import co.edu.sena.project_yaml.domain.enumeration.Estado;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ProductoRepositoryTest {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    @Order(1)
    void insert(){
        facturaRepository.deleteAll();
        tipoDocumentoRepository.deleteAll();
        productoRepository.deleteAll();
        clienteRepository.deleteAll();

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

        Producto producto1 = new Producto(null, "718349edfjh", "Pan Rollo", 500.0, 50, "ejeplo.com", "Pan rollo");
        Producto producto2 = new Producto(null, "718349efgdfjh", "Pan Calentano", 500.0, 50, "ejeplo.com", "Pan Calentano");
        Producto producto3 = new Producto(null, "718349e3425dfjh", "Pan Ojaldrado", 500.0, 50, "ejeplo.com", "Pan Ojaldrado");
        Producto producto4 = new Producto(null, "718343459edfjh", "Pan Coco", 500.0, 50, "ejeplo.com", "Pan Coco");

        productoRepository.insert(producto1);
        productoRepository.insert(producto2);
        productoRepository.insert(producto3);
        productoRepository.insert(producto4);

        factura1.getProductos().add(new ProductoEmbedded(producto1.getReferencia(), producto1.getNombreProducto(), producto1.getPrecio(), 6));
        factura1.getProductos().add(new ProductoEmbedded(producto2.getReferencia(), producto2.getNombreProducto(), producto2.getPrecio(), 6));
        factura1.getProductos().add(new ProductoEmbedded(producto3.getReferencia(), producto3.getNombreProducto(), producto3.getPrecio(), 6));
        factura1.getProductos().add(new ProductoEmbedded(producto4.getReferencia(), producto4.getNombreProducto(), producto4.getPrecio(), 6));

        productoRepository.save(producto1);
        productoRepository.save(producto2);
        productoRepository.save(producto3);
        productoRepository.save(producto4);

        facturaRepository.insert(factura1);
        facturaRepository.insert(factura2);
        facturaRepository.insert(factura3);
        facturaRepository.insert(factura4);

        clienteGuardado.getFacturaSet().add(factura1);
        clienteGuardado.getFacturaSet().add(factura2);
        clienteGuardado.getFacturaSet().add(factura3);
        clienteGuardado.getFacturaSet().add(factura4);

        clienteRepository.save(clienteGuardado);



    }

}