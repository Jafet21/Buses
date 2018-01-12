package controladores;

import com.google.gson.Gson;
import modelos.Empresa;
import spark.Request;
import spark.Response;

public class ControladorEmpresas {
    //private RepositorioEmpresas repositorioEmpresas; falta este repositorio
    private Gson gson;

    public ControladorEmpresas(Gson gson){
        this.gson = gson;
    }

    public void registrarEmpresa(Request request, Response response){
        Empresa empresa = Empresa.builder()
                .correo(request.queryParams("correo"))
                .nombre(request.queryParams("nombre"))
                .telefono(request.queryParams("telefono"))
                .build();

        //repositorioEmpresas.insertarEmpresa(empresa);
    }

}
