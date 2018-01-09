package config;

import controllers.IndexController;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.function.BiFunction;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {
    private static final VelocityTemplateEngine templateEngine = new VelocityTemplateEngine();
    private static final IndexController indexController = new IndexController();

    public static void main(String[] args) {
        port(8080);
        configureRoutes();
    }

    public static void configureRoutes(){
        get("/", render(indexController::index));
        get("/saludo/:name", render(indexController::saludo));
    }

    public static Route render(BiFunction<Request, Response, ModelAndView> viewAction){
        return (req, res)-> templateEngine.render(viewAction.apply(req, res));
    }
}