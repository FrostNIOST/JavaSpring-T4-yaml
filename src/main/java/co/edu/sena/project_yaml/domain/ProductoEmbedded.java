package co.edu.sena.project_yaml.domain;

import java.util.Objects;

public class ProductoEmbedded {
    private String referencia;
    private String nombreProducto;
    private double precioVenta;
    private int cantidadVendida;

    public ProductoEmbedded(String referencia, String nombreProducto, double precioVenta, int cantidadVendida) {
        this.referencia = referencia;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.cantidadVendida = cantidadVendida;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductoEmbedded that)) return false;
        return Objects.equals(referencia, that.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(referencia);
    }
}
