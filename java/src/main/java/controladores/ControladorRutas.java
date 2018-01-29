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
        ruta.setEmpresaId(request.session().attribute("id"));
        ruta.setDescripcion(request.queryParams("descripcion"));
        ruta.setTiempoEstimado(Integer.parseInt(request.queryParams("tiempoEstimado")));

        repositorioRutas.insertarRuta(ruta);
        return "OK";
    }

    public String agregarHorario(Request request, Response response){
        int rutaId = Integer.parseInt(request.queryParams("rutaId"));
        String hora = request.queryParams("horario");
        repositorioRutas.agregarHorario(rutaId, hora);

        return "OK";
    }

    public String obtenerRutas(Request request, Response response){
        List<Ruta> rutas = repositorioRutas.obtenerRutas(request.session().attribute("id"));

        response.type("application/json");
        return gson.toJson(rutas);
    }

    public String eliminarRuta(Request request, Response response){
        int id = Integer.parseInt(request.params(":rutaId"));
        repositorioRutas.eliminarRuta(id);
        return "OK";
    }


}
