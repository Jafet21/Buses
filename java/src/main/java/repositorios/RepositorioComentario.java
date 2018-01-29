package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Comentario;

public class RepositorioComentario {

    public RepositorioComentario(Connection conneccion) {
        this.conneccion = conneccion;
    }
    
    public void insertarComentario(Comentario comentario) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("insert into comentarios (id, nombreUsuarioC, nombreRuta, comentario, fecha) values (seq.nextval,?,?,?,?)");
            preparedStatement.setString(1, comentario.getNombreUsuarioC());
            preparedStatement.setString(2, comentario.getNombreRuta());
            preparedStatement.setString(3, comentario.getComentario());
            preparedStatement.setString(4,comentario.getFecha());
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarComentario(int id) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("delete from comentarios where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comentario> obtenerComentarios() {
        try{
            List<Comentario> comentarios = new ArrayList<>();
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from comentarios");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comentario comentario = new Comentario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombreUsuarioC"),
                        resultSet.getString("nombreRuta"),
                        resultSet.getString("comentario"),
                        resultSet.getString("fecha")
                );
                comentarios.add(comentario);
            }
            return comentarios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private Connection conneccion;
}
