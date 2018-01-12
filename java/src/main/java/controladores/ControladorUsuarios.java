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
        Usuario usuario = Usuario.builder()
                .nombre(request.queryParams("nombre"))
                .apellidos(request.queryParams("apellidos"))
                .correo(request.queryParams("correo"))
                .contrasena(request.queryParams("contrasena"))
                .build();

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

    //Este metodo saca los usuarios de la base y los devuelve en la vista procesadolos directamente desde el servidor
    //Es para usarse como ejemplo en case de que se vea conveniente en algun momento
    public ModelAndView listarUsuariosEnVista(Request request, Response response){
        List<Usuario> usuarios = repositorioUsuarios.obtenerUsuarios();
        Map<String, Object> parametrosParaVista = new HashMap<>();
        parametrosParaVista.put("usuarios", usuarios);
        return new ModelAndView(parametrosParaVista, "usuarios.vm");
    }
}
