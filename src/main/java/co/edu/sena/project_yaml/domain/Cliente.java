package co.edu.sena.project_yaml.domain;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import co.edu.sena.project_yaml.domain.AllowedCombination;


import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "cliente")

@AllowedCombination

@CompoundIndex(
        name = "idx_unique_cliente",
        def = "{'numero_documento': 1, 'tipo_documento': 1}",
        unique = true
)

public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Nonnull
    @Size(max = 50)
    @Field("numero_documento")
    private String numeroDocumento;


    @Nonnull
    @Size(max = 50)
    @Field ("primer_nombre")
    private String primerNombre;

    @Field("segundo_nombre")
    @Size(max = 50)
    private String segundoNombre;

    @Nonnull
    @Size(max = 50)
    @Field("primer_apellido")
    private String primerApellido;

    @Field("segundo_apellido")
    @Size(max = 50)
    private String segundoApellido;

    @Field("tipo_documento")
    private TipoDocumentoEmbedded tipoDocumentoEmbedded;

    @DocumentReference
    @Field("cuenta")
    private Cuenta cuenta;

    private Set<Factura> facturaSet = new HashSet<>();

    public Cliente(String id, @Nonnull String numeroDocumento, @Nonnull String primerNombre, String segundoNombre, @Nonnull String primerApellido, String segundoApellido) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Nonnull
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(@Nonnull String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Nonnull
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(@Nonnull String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Nonnull
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(@Nonnull String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public TipoDocumentoEmbedded getTipoDocumentoEmbedded() {
        return tipoDocumentoEmbedded;
    }

    public void setTipoDocumentoEmbedded(TipoDocumentoEmbedded tipoDocumentoEmbedded) {
        this.tipoDocumentoEmbedded = tipoDocumentoEmbedded;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
