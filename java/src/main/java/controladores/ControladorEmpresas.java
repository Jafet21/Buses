package controladores;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelos.Empresa;
import repositorios.RepositorioEmpresas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorEmpresas {
   private RepositorioEmpresas repositorioEmpresas;
    private Gson gson;

    public ControladorEmpresas(RepositorioEmpresas repositorioEmpresas, Gson gson){
        this.repositorioEmpresas = repositorioEmpresas;
        this.gson = gson;
    }

    public String registrarEmpresa(Request request, Response response){
        Empresa empresa = new Empresa(request.queryParams("nombreEmpresa"),
        request.queryParams("correoEmpresa"),
        request.queryParams("contrasenaEmpresa"),
        request.queryParams("telefonoEmpresa"));
       
        repositorioEmpresas.insertarEmpresa(empresa);
        return "OK";
    }

    //Este es un ejemplo que devuelve un json con el primer usuario
    public String listarUsuariosEnJson(Request request, Response response){
        //ejemplo de otro metodo
        List<Empresa> empresas = repositorioEmpresas.obtenerEmpresas();

        response.type("application/json");
        return gson.toJson(empresas);
    }

    //Este metodo saca los usuarios de la base y los devuelve en la vista procesadolos directamente desde el servidor
    //Es para usarse como ejemplo en case de que se vea conveniente en algun momento
    
    public ModelAndView listarUsuariosEnVista(Request request, Response response){
        List<Empresa> empresas = repositorioEmpresas.obtenerEmpresas();
        Map<String, Object> parametrosParaVista = new HashMap<>();
        parametrosParaVista.put("empresas", empresas);
        return new ModelAndView(parametrosParaVista, "empresas.vm");
    }
}
