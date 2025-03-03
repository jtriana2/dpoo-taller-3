package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class CalculadoraTarifas {
    public abstract int calcularTarifa(Tiquete tiquete);
}