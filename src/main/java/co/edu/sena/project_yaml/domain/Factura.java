package co.edu.sena.project_yaml.domain;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Objects;


@CompoundIndex(
        name = "idx_unique_factura",
        def = "{'numeroFactura': 1, 'anio': 1}",
        unique = true
)

@Document(collection = "factura")
public class Factura {
    private String id;
    private long numeroFactura;
    private int anio;
    private Date fechaDeEmision;
    private double total;
    private double iva;
    private double subtotal;

    @DBRef
    @Field("cliente")
    private Cliente cliente;

    public Factura(String id, long numeroFactura, int anio, Date fechaDeEmision, double total, double iva, double subtotal) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.anio = anio;
        this.fechaDeEmision = fechaDeEmision;
        this.total = total;
        this.iva = iva;
        this.subtotal = subtotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(Date fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Factura factura)) return false;
        return Objects.equals(id, factura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
