package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private List<Tiquete> tiquetes;
    private boolean realizado;

    public Vuelo(String fecha, Ruta ruta, Avion avion) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
        this.realizado = false;
    }

    public String getFecha() {
        return fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Avion getAvion() {
        return avion;
    }

    public int getCapacidadDisponible() {
        return avion.getCapacidad() - tiquetes.size();
    }

    public int getTarifa() {
        return ruta.getTarifa();
    }

    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetes.add(tiquete);
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void marcarComoRealizado() {
        this.realizado = true;
    }
}
