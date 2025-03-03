package uniandes.dpoo.aerolinea.modelo.cliente;

public abstract class Cliente {
    protected String identificador;

    public Cliente(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public abstract String getTipoCliente();
}