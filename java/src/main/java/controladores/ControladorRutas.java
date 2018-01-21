package controladores;

import com.google.gson.Gson;
import modelos.Ruta;
import repositorios.RepositorioRutas;
import spark.Request;
import spark.Response;

import java.util.List;

public class ControladorRutas {
    private RepositorioRutas repositorioRutas;
    private Gson gson;

    public ControladorRutas(RepositorioRutas repositorioRutas, Gson gson) {
        this.repositorioRutas = repositorioRutas;
        this.gson = gson;
    }

    public String registrarRuta(Request request, Response response){
        Ruta ruta = new Ruta();
        ruta.setEmpresaId(1);
        ruta.setDescripcion(request.queryParams("descripcion"));
        ruta.setTiempoEstimado(Integer.parseInt(request.queryParams("tiempoEstimado")));

        repositorioRutas.insertarRuta(ruta);
        return "OK";
    }

    public String obtenerRutas(Request request, Response response){
        List<Ruta> rutas = repositorioRutas.obtenerRutas(1);

        response.type("application/json");
        return gson.toJson(rutas);
    }


}
