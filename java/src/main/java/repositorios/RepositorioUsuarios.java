package repositorios;

import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Aqui van las acciones para guardar y traer usuarios de la base
public class RepositorioUsuarios {

    private Connection conneccion;

    public RepositorioUsuarios(Connection conneccion) {
        this.conneccion = conneccion;
    }

    public void insertarUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("insert into usuarios (id, nombre, apellidos, correo, contrasena) values (seq.nextval,?,?,?,?)");
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidos());
            preparedStatement.setString(3, usuario.getCorreo());
            preparedStatement.setString(4, usuario.getContrasena());
            preparedStatement.execute();
        } catch (Exception e) {
        }
    }

    public Usuario obtenerUsuario(String correo) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios where correo = ?");
            preparedStatement.setNString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(resultSet.getInt(1), // como lo arreglo
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correo"),
                        resultSet.getString("contrasena"));

            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Usuario> obtenerUsuarios() {
        try {
            List<Usuario> usuarios = new ArrayList<>();
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(new Usuario(resultSet.getInt(1),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correo"),
                        resultSet.getString("contrasena")));
            }
            return usuarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Usuario obtenerUsuarioLogeo(String correo, String contrasena) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios where correo = ? and contrasena= ?" );
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correo"),
                        resultSet.getString("contrasena"));
          

            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
