package config;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Connection;
import java.sql.DriverManager;

//Aqui es para separar un poco las configuraciones generales, cualquier otra cosa meterla aca

public class Configuraciones {

    @SneakyThrows
    public static Connection configurarBaseDeDatos(){
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","buses","buses");
    }

    public static VelocityTemplateEngine configurarTemplateEngine(){
        return new VelocityTemplateEngine();
    }

    public static Gson configurarGson(){
        return new Gson();
    }
}
