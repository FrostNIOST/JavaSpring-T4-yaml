package co.edu.sena.project_yaml.domain.enumeration;

public enum Estado {
    ACTIVO ("Activo"),
    INACTIVO ("Inactivo");

    private final String valor;

    Estado(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
