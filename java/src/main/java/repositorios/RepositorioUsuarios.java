package repositorios;
import lombok.SneakyThrows;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Aqui van las acciones para guardar y traer usuarios de la base

public class RepositorioUsuarios {
    private Connection conneccion;

    public RepositorioUsuarios(Connection conneccion){
        this.conneccion = conneccion;
    }

    @SneakyThrows
    public void insertarUsuario(Usuario usuario){
        PreparedStatement preparedStatement = conneccion.prepareStatement("insert into usuarios (id, nombre, apellidos, correo, contrasena) values (seq.nextval,?,?,?,?)");
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getApellidos());
        preparedStatement.setString(3, usuario.getCorreo());
        preparedStatement.setString(4, usuario.getContrasena());
        preparedStatement.execute();
    }

    @SneakyThrows
    public Usuario obtenerUsuario(int id){
        PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return Usuario.builder()
                    .id(resultSet.getInt(id))
                    .nombre(resultSet.getString("nombre"))
                    .correo(resultSet.getString("correo"))
                    .apellidos(resultSet.getString("apellidos"))
                    .contrasena(resultSet.getString("contrasena"))
                    .build();
        }
        else {
            return null;
        }
    }

    @SneakyThrows
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement preparedStatement = conneccion.prepareStatement("select * from usuarios");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Usuario usuario = Usuario.builder()
                    .id(resultSet.getInt("id"))
                    .nombre(resultSet.getString("nombre"))
                    .correo(resultSet.getString("correo"))
                    .apellidos(resultSet.getString("apellidos"))
                    .contrasena(resultSet.getString("contrasena"))
                    .build();
            usuarios.add(usuario);
        }
        return usuarios;
    }
}
