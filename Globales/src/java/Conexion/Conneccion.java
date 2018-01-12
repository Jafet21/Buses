/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author User
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Conneccion {
    public static Connection instance;

    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            instance = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","buses","buses");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception{
//            RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios();
//            repositorioUsuarios.insertarUsuario(new Usuario("Jafet", "jafet@gmail.com", "123"));
    }
}

