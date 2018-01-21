package config;

import com.google.gson.Gson;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Connection;
import java.sql.DriverManager;

//Aqui es para separar un poco las configuraciones generales, cualquier otra cosa meterla aca

import oracle.jdbc.driver.OracleDriver;


public class Configuraciones {

  
    public static Connection configurarBaseDeDatos(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","buses","buses");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        
    }

    public static VelocityTemplateEngine configurarTemplateEngine(){
        return new VelocityTemplateEngine();
    }

    public static Gson configurarGson(){
        return new Gson();
    }
}
