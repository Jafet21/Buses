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

    public Usuario obtenerUsuario(int id) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(resultSet.getInt(id),
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
        try{
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
         // set
        }
        return usuarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
