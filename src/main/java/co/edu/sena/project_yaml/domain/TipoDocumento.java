package co.edu.sena.project_yaml.domain;

public class TipoDocumento {
    private String id;
    private String siglas;
    private String nombreDocumento;
    private String estado;


    public TipoDocumento(String id, String siglas, String nombreDocumento, String estado) {
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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
