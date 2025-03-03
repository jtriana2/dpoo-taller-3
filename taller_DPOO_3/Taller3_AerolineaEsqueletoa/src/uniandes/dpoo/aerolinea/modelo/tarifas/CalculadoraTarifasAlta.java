package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class CalculadoraTarifasAlta extends CalculadoraTarifas {
    @Override
    public int calcularTarifa(Tiquete tiquete) {
        return (int) (tiquete.getTarifa() * 1.2);
    }
}