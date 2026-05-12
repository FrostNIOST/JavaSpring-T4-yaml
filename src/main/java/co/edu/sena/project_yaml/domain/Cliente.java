package co.edu.sena.project_yaml.domain;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "cliente")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    private String id;

    @Size(max = 50)
    @Nonnull
    @Field("numero_documento")
    private String numeroDocumento;


    @Nonnull
    @Field ("primer_nombre")
    private String primerNombre;

    @Field("segundo_nombre")
    private String segundoNombre;

    @Nonnull
    @Field("primer_apellido")
    private String primerApellido;

    @Field("segundo_apellido")
    private String segundoApellido;

    @DBRef
    @Field("tipo_documento")
    private TipoDocumento tipoDocumento;

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

    @Nonnull
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(@Nonnull String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Nonnull
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(@Nonnull String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Nonnull
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(@Nonnull String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
