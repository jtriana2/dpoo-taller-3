package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
    public static final String NATURAL = "Natural";

    public ClienteNatural(String identificador) {
        super(identificador);
    }

    @Override
    public String getTipoCliente() {
        return NATURAL;
    }
}