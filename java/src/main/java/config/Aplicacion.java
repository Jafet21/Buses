package config;

import com.google.gson.Gson;
import controladores.ControladorEmpresas;
import controladores.ControladorUsuarios;
import repositorios.RepositorioUsuarios;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Connection;
import repositorios.RepositorioEmpresas;

import static spark.Spark.*;

//Aqui es el main que corre la app, tiene las configuraciones del servidor y las rutas para las acciones web
public class Aplicacion {

    //utilitarios
    private static final Connection coneccion = Configuraciones.configurarBaseDeDatos();//Coneccion a la base de datos
    private static final Gson gson = Configuraciones.configurarGson();//para jsons
    private static final VelocityTemplateEngine templateEngine = Configuraciones.configurarTemplateEngine();//Para los html dinamicos (.vm)

    //Repositorios
    private static final RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios(coneccion);
    private static final RepositorioEmpresas repositorioEmpresas = new RepositorioEmpresas(coneccion);

    //Controladores
    private static final ControladorUsuarios controladorUsuarios = new ControladorUsuarios(repositorioUsuarios,gson);
    private static final ControladorEmpresas controladorEmpresas = new ControladorEmpresas(repositorioEmpresas,gson);

    public static void main(String[] args) {
        configurarServidor();
        configurarRutasWeb();
        
        
    }

    public static void configurarRutasWeb() {

        // Usuarios
        post("/registrarUsuario", controladorUsuarios::registrarUsuario);//recibe el formulario de registro de usuario
        get("/listarUsuarios", controladorUsuarios::listarUsuariosEnVista, Aplicacion::renderizar);//ejemplo de pagina con contenido dinamico desde el servidor para no usar ajax
        get("/listarUsuariosJson", controladorUsuarios::listarUsuariosEnJson);//devuelve usuarios en json para ajax

        // Empresas
        post("/registrarEmpresa", controladorEmpresas::registrarEmpresa);//recibe el formulario de registro de usuario
//        get("/listarEmpresas", controladorEmpresas::listarEmpresasEnVista, Aplicacion::renderizar);//ejemplo de pagina con contenido dinamico desde el servidor para no usar ajax
//        get("/listarEmpresasJson", controladorEmpresas::listarEmpresasEnJson);//devuelve usuarios en json para ajax

    }

    public static void configurarServidor() {
        port(8081);
        staticFiles.location("/web");
    }

    public static String renderizar(Object modelAndView) {
        return templateEngine.render(modelAndView);
    }
}
