package controladores;

import com.google.gson.Gson;
import modelos.Empresa;
import repositorios.RepositorioEmpresas;
import spark.Request;
import spark.Response;

import java.util.List;

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

    public String obtenerEmpresas(Request request, Response response){
        List<Empresa> empresas = repositorioEmpresas.obtenerEmpresas();

        response.type("application/json");
        return gson.toJson(empresas);
    }

    public String empresaLogeo(Request request, Response response){
        Empresa empresaLogeo = repositorioEmpresas.obtenerEmpresaLogeo(request.queryParams("correoEmpresa"), request.queryParams("contrasenaEmpresa"));
        response.type("application/json");
        return gson.toJson(empresaLogeo);
    }
}
