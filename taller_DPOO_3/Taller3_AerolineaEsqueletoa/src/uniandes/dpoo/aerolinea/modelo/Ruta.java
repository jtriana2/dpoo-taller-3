package uniandes.dpoo.aerolinea.modelo;

public class Ruta {
    private String codigoRuta;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int tarifa;

    public Ruta(String codigoRuta, Aeropuerto origen, Aeropuerto destino, int tarifa) {
        this.codigoRuta = codigoRuta;
        this.origen = origen;
        this.destino = destino;
        this.tarifa = tarifa;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getTarifa() {
        return tarifa;
    }
}