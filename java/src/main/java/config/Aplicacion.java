package config;

import com.google.gson.Gson;
import controladores.ControladorComentarios;
import controladores.ControladorEmpresas;
import controladores.ControladorRutas;
import controladores.ControladorUsuarios;
import repositorios.RepositorioRutas;
import repositorios.RepositorioUsuarios;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Connection;
import repositorios.RepositorioComentario;
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
    private static final RepositorioRutas repositoriosRutas = new RepositorioRutas(coneccion);
    private static final RepositorioComentario repositoriosComentarios = new RepositorioComentario(coneccion);

    //Controladores
    private static final ControladorUsuarios controladorUsuarios = new ControladorUsuarios(repositorioUsuarios, gson);
    private static final ControladorEmpresas controladorEmpresas = new ControladorEmpresas(repositorioEmpresas, gson);
    private static final ControladorRutas controladorRutas = new ControladorRutas(repositoriosRutas, gson);
    private static final ControladorComentarios controladorComentarios = new ControladorComentarios(repositoriosComentarios, gson);


    public static void main(String[] args) {
        configurarServidor();
        configurarRutasWeb();

    }

    public static void configurarRutasWeb() {

        // Usuarios
        post("/registrarUsuario", controladorUsuarios::registrarUsuario);//recibe el formulario de registro de usuario
        get("/obtenerUsuarios", controladorUsuarios::listarUsuariosEnJson);//devuelve usuarios en json para ajax
        post("/usuarioLogeo", controladorUsuarios::usuarioLogeo);

        // Empresas
        post("/registrarEmpresa", controladorEmpresas::registrarEmpresa);//recibe el formulario de registro de empresa
        get("/obtenerEmpresas", controladorEmpresas::obtenerEmpresas);//devuelve empresas en json para ajax
        post("/EmpresaLogeo", controladorEmpresas::empresaLogeo);

        //Rutas
        post("/registrarRuta", controladorRutas::registrarRuta);//recibe el formulario de registro de ruta
        get("/obtenerRutas", controladorRutas::obtenerRutas);//devuelve empresas en json para ajax
        post("/eliminarRuta/:rutaId", controladorRutas::eliminarRuta);//devuelve empresas en json para ajax
        post("/agregarHorario", controladorRutas::agregarHorario);

        //Usuario logueo
        get("/usuarioLogeo", controladorUsuarios::usuarioLogeo);//devuelve empresas en json para ajax
        
         //Comentarios
        post("/registrarComentario", controladorComentarios::registrarComentario);//recibe el formulario de registro de Comentarios
        get("/obtenerComentarios", controladorComentarios::obtenerComentarios);//devuelve Comentarios en json para ajax
        post("/eliminarComentario", controladorComentarios::eliminarComentario);//devuelve Comentarios en json para ajax
   

    }

    public static void configurarServidor() {
        port(8081);
        staticFiles.location("/web");
    }

    public static String renderizar(Object modelAndView) {
        return templateEngine.render(modelAndView);
    }
}
