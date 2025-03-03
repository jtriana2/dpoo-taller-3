package uniandes.dpoo.aerolinea.modelo;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private double latitud;
    private double longitud;

    public Aeropuerto(String codigo, String nombre, double latitud, double longitud) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}