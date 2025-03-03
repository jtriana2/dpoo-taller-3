package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class CentralPersistencia {

    /**
     * La cadena utilizada para identificar a los archivos en formato JSON.
     */
    public static final String JSON = "JSON";

    /**
     * La cadena utilizada para identificar a los archivos en texto plano.
     */
    public static final String PLAIN = "PlainText";

    /**
     * Retorna una nueva instancia de una clase capaz de cargar y salvar los datos de una aerolínea.
     * Puede ser `PersistenciaAerolineaJson` o `PersistenciaAerolineaPlaintext`.
     * 
     * @param tipoArchivo El tipo del archivo que será usado para cargar la información de la aerolínea.
     * @return Una instancia de `IPersistenciaAerolinea` adecuada para el tipo de archivo.
     * @throws TipoInvalidoException Se lanza si el tipo de archivo no es válido.
     */
    public static IPersistenciaAerolinea getPersistenciaAerolinea(String tipoArchivo) throws TipoInvalidoException {
        if (JSON.equals(tipoArchivo)) {
            return new PersistenciaAerolineaJson();
        } else if (PLAIN.equals(tipoArchivo)) {
            return new PersistenciaAerolineaPlaintext();
        } else {
            throw new TipoInvalidoException(tipoArchivo);
        }
    }

    /**
     * Retorna una nueva instancia de una clase capaz de cargar y salvar los datos de los tiquetes de una aerolínea.
     * Solo puede devolver `PersistenciaTiquetesJson`, ya que el formato PlainText no está implementado para tiquetes.
     * 
     * @param tipoArchivo El tipo del archivo que será usado para cargar la información de los tiquetes.
     * @return Una instancia de `IPersistenciaTiquetes` adecuada para el tipo de archivo.
     * @throws TipoInvalidoException Se lanza si el tipo de archivo no es válido.
     */
    public static IPersistenciaTiquetes getPersistenciaTiquetes(String tipoArchivo) throws TipoInvalidoException {
        if (JSON.equals(tipoArchivo)) {
            return new PersistenciaTiquetesJson();
        } else {
            throw new TipoInvalidoException(tipoArchivo);
        }
    }
}
