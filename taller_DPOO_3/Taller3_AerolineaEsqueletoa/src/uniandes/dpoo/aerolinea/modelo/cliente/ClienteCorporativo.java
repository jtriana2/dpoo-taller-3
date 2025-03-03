package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

public class ClienteCorporativo extends Cliente {
    public static final String CORPORATIVO = "Corporativo";
    private String nombreEmpresa;
    private int tamanoEmpresa;

    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
        super(nombreEmpresa);
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    @Override
    public String getTipoCliente() {
        return CORPORATIVO;
    }

    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamanoEmpresa = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tamanoEmpresa);
    }

    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        return jobject;
    }
}
