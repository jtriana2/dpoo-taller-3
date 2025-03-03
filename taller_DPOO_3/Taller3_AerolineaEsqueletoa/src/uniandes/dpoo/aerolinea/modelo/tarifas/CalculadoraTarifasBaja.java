package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class CalculadoraTarifasBaja extends CalculadoraTarifas {
    @Override
    public int calcularTarifa(Tiquete tiquete) {
        return (int) (tiquete.getTarifa() * 0.8);
    }
}