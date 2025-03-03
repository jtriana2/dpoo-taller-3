package uniandes.dpoo.aerolinea.consola;
import java.io.IOException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;

public class ConsolaAerolinea extends ConsolaBasica {
    private Aerolinea unaAerolinea;

    public void correrAplicacion() {
        try {
            unaAerolinea = new Aerolinea();
            String archivo = "tiquetes.json";
            unaAerolinea.cargarTiquetes("./datos/" + archivo, CentralPersistencia.JSON);
            System.out.println("Tiquetes cargados correctamente.");
        } catch (TipoInvalidoException | IOException | InformacionInconsistenteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsolaAerolinea ca = new ConsolaAerolinea();
        ca.correrAplicacion();
    }
}