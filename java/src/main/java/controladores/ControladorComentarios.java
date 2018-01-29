package controladores;

import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelos.Comentario;
import repositorios.RepositorioComentario;
import spark.Request;
import spark.Response;

public class ControladorComentarios {

    public ControladorComentarios(RepositorioComentario repositorioComentarios, Gson gson) {
        this.repositorioComentarios = repositorioComentarios;
        this.gson = gson;
    }
    
    public String registrarComentario(Request request, Response response) throws ParseException{
        Comentario comentario = new Comentario();
        comentario.setNombreUsuarioC(request.queryParams("nombreUsuarioC"));
        comentario.setNombreRuta(request.queryParams("nombreRuta"));
        comentario.setComentario(request.queryParams("comentario"));
        comentario.setFecha(request.queryParams("fecha"));

        repositorioComentarios.insertarComentario(comentario);
        return "OK";
    }

    public String obtenerComentarios(Request request, Response response){
        List<Comentario> comentarios = repositorioComentarios.obtenerComentarios();

        response.type("application/json");
        return gson.toJson(comentarios);
    }

    public String eliminarComentario(Request request, Response response){
        int id = Integer.parseInt(request.queryParams("id"));

        repositorioComentarios.eliminarComentario(id);
        return "OK";
    }
    
    private RepositorioComentario repositorioComentarios;
    private Gson gson;
}
