package co.edu.sena.project_yaml.domain;

import co.edu.sena.project_yaml.domain.enumeration.Estado;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "tipo_documento")
public class TipoDocumento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Nonnull
    @Indexed(unique = true, name = "_idx_type_dni")
    @Field("sigla")
    @Size(max = 10)
    private String siglas;

    @Nonnull
    @Indexed(unique = true, name = "_idx_id_type_document")
    @Field("nombre_documento")
    @Size(max=100)
    private String nombreDocumento;

    @Nonnull
    @Field("estado")
    private Estado estado;

    public TipoDocumento(String id, @Nonnull String siglas, @Nonnull String nombreDocumento, @Nonnull Estado estado) {
        this.id = id;
        this.siglas = siglas;
        this.nombreDocumento = nombreDocumento;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Nonnull
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(@Nonnull String siglas) {
        this.siglas = siglas;
    }

    @Nonnull
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(@Nonnull String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @Nonnull
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(@Nonnull Estado estado) {
        this.estado = estado;
    }

    public static class TipoDocumentoEmbedded {
        private String sigla;
        private String nombreDocumento;

        public TipoDocumentoEmbedded(String sigla, String nombreDocumento) {
            this.sigla = sigla;
            this.nombreDocumento = nombreDocumento;
        }

        public String getSigla() {
            return sigla;
        }

        public void setSigla(String sigla) {
            this.sigla = sigla;
        }

        public String getNombreDocumento() {
            return nombreDocumento;
        }

        public void setNombreDocumento(String nombreDocumento) {
            this.nombreDocumento = nombreDocumento;
        }
    }

}
