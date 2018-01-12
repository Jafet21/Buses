/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private Connection conneccion;

    /*
    *  Ejemplo de uso en el servlet\
    *
    *  RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios();
    *  repositorioUsuarios.insertarUsuario(new Usuario("Jafet", "jafet@gmail.com", "123"));
    * */

    public RepositorioUsuarios(){
        this.conneccion = Conneccion.instance;
    }

    public boolean insertarUsuario(Usuario usuario){
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("insert into users (id, name, email, password) values (seq.nextval,?,?,?)");
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getContraseña());
            return preparedStatement.execute();
        }catch (SQLException e){
            return false;
        }
    }

    public Usuario getUsuario(int id){
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from users where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Usuario(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
            return null;
        }catch (SQLException e){
            return null;
        }
    }

    public List<Usuario> getUsuarios(){
        try {
            List<Usuario> usuarios = new ArrayList<>();
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                usuarios.add(
                        new Usuario(
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        )
                );
            }
            return usuarios;
        }catch (SQLException e){
            return null;
        }
    }
}
