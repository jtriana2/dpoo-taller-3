package uniandes.dpoo.aerolinea.modelo;

import java.io.IOException;
import java.util.*;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Aerolinea {
    private List<Avion> aviones;
    private Map<String, Ruta> rutas;
    private List<Vuelo> vuelos;
    private Map<String, Cliente> clientes;

    public Aerolinea() {
        aviones = new LinkedList<>();
        rutas = new HashMap<>();
        vuelos = new LinkedList<>();
        clientes = new HashMap<>();
    }

    public void agregarRuta(Ruta ruta) {
        this.rutas.put(ruta.getCodigoRuta(), ruta);
    }

    public void agregarAvion(Avion avion) {
        this.aviones.add(avion);
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.put(cliente.getIdentificador(), cliente);
    }

    public boolean existeCliente(String identificadorCliente) {
        return this.clientes.containsKey(identificadorCliente);
    }

    public Cliente getCliente(String identificadorCliente) {
        return this.clientes.get(identificadorCliente);
    }

    public Collection<Avion> getAviones() {
        return aviones;
    }

    public Collection<Ruta> getRutas() {
        return rutas.values();
    }

    public Ruta getRuta(String codigoRuta) {
        return rutas.get(codigoRuta);
    }

    public Collection<Vuelo> getVuelos() {
        return vuelos;
    }

    public Vuelo getVuelo(String codigoRuta, String fechaVuelo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getRuta().getCodigoRuta().equals(codigoRuta) && vuelo.getFecha().equals(fechaVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public Collection<Tiquete> getTiquetes() {
        List<Tiquete> tiquetes = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            tiquetes.addAll(vuelo.getTiquetes());
        }
        return tiquetes;
    }

    public void cargarAerolinea(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException, InformacionInconsistenteException {
        CentralPersistencia.getPersistenciaAerolinea(tipoArchivo).cargarAerolinea(archivo, this);
    }

    public void salvarAerolinea(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException {
        CentralPersistencia.getPersistenciaAerolinea(tipoArchivo).salvarAerolinea(archivo, this);
    }

    public void programarVuelo(String fecha, String codigoRuta, String nombreAvion) throws Exception {
        Ruta ruta = getRuta(codigoRuta);
        Avion avion = null;
        for (Avion a : aviones) {
            if (a.getNombre().equals(nombreAvion)) {
                avion = a;
                break;
            }
        }
        if (ruta == null || avion == null) {
            throw new Exception("Ruta o avión no encontrado.");
        }
        Vuelo vuelo = new Vuelo(fecha, ruta, avion);
        vuelos.add(vuelo);
    }

    public int venderTiquetes(String identificadorCliente, String fecha, String codigoRuta, int cantidad) throws VueloSobrevendidoException, Exception {
        Cliente cliente = getCliente(identificadorCliente);
        Vuelo vuelo = getVuelo(codigoRuta, fecha);

        if (cliente == null || vuelo == null) {
            throw new Exception("Cliente o vuelo no encontrado.");
        }

        if (vuelo.getCapacidadDisponible() < cantidad) {
            throw new VueloSobrevendidoException(vuelo);
        }

        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = GeneradorTiquetes.generarTiquete(vuelo, cliente, vuelo.getTarifa());
            vuelo.agregarTiquete(tiquete);
            total += vuelo.getTarifa();
        }
        return total;
    }

    public void registrarVueloRealizado(String fecha, String codigoRuta) {
        Vuelo vuelo = getVuelo(codigoRuta, fecha);
        if (vuelo != null) {
            vuelo.marcarComoRealizado();
        }
    }

    public String consultarSaldoPendienteCliente(String identificadorCliente) {
        Cliente cliente = getCliente(identificadorCliente);
        if (cliente == null) {
            return "Cliente no encontrado.";
        }
        int saldo = 0;
        for (Tiquete tiquete : getTiquetes()) {
            if (tiquete.getCliente().equals(cliente) && !tiquete.esUsado()) {
                saldo += tiquete.getTarifa();
            }
        }
        return "Saldo pendiente: " + saldo;
    }
}