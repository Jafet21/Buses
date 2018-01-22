package controladores;

import com.google.gson.Gson;
import modelos.Usuario;
import repositorios.RepositorioUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Aqui van los metodos para los usuarios, deben estar ligados con una ruta en Aplicacion.java para que puedan ser llamados desde el navegador

public class ControladorUsuarios {
    private RepositorioUsuarios repositorioUsuarios;
    private Gson gson;

    public ControladorUsuarios(RepositorioUsuarios repositorioUsuarios, Gson gson){
        this.repositorioUsuarios = repositorioUsuarios;
        this.gson = gson;
    }

    public String registrarUsuario(Request request, Response response){
        Usuario usuario = new Usuario(request.queryParams("nombreUsuario"),
        request.queryParams("apellidos"),
        request.queryParams("correoUsuario"),
        request.queryParams("contrasenaUsuario"));
       

        repositorioUsuarios.insertarUsuario(usuario);
        return "OK";
    }

    //Este es un ejemplo que devuelve un json con el primer usuario
    public String listarUsuariosEnJson(Request request, Response response){
        //ejemplo de otro metodo
        List<Usuario> usuarios = repositorioUsuarios.obtenerUsuarios();

        response.type("application/json");
        return gson.toJson(usuarios);
    }
    
    public String usuarioLogeo(Request request, Response response){
        Usuario usuarioLogeo = repositorioUsuarios.obtenerUsuarioLogeo(request.queryParams("correoUsuario"), request.queryParams("contrasenaUsuario"));

        response.type("application/json");
        return gson.toJson(usuarioLogeo);
    }

}
