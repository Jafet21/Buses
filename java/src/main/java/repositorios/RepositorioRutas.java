package repositorios;

import modelos.Ruta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioRutas {
    private Connection conneccion;

    public RepositorioRutas(Connection conneccion) {
        this.conneccion = conneccion;
    }

    public void insertarRuta(Ruta ruta) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("insert into rutas (id, empresaId, descripcion, latitudInicio, longitudInicio, latitudFinal, longitudFinal, tiempoEstimado) values (seq.nextval,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, ruta.getEmpresaId());
            preparedStatement.setString(2, ruta.getDescripcion());
            preparedStatement.setFloat(3, ruta.getLatitudInicio());
            preparedStatement.setFloat(4, ruta.getLongitudInicio());
            preparedStatement.setFloat(5, ruta.getLatitudFinal());
            preparedStatement.setFloat(6, ruta.getLongitudFinal());
            preparedStatement.setInt(7, ruta.getTiempoEstimado());
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarRuta(int id) {
        try {
            PreparedStatement preparedStatement = conneccion.prepareStatement("delete from rutas where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ruta> obtenerRutas(int companiaId) {
        try{
            List<Ruta> rutas = new ArrayList<>();
            PreparedStatement preparedStatement = conneccion.prepareStatement("select * from rutas where empresaId = ?");
            preparedStatement.setInt(1, companiaId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ruta ruta = new Ruta(
                        resultSet.getInt("id"),
                        resultSet.getInt("empresaId"),
                        resultSet.getString("descripcion"),
                        resultSet.getFloat("latitudInicio"),
                        resultSet.getFloat("longitudInicio"),
                        resultSet.getFloat("latitudFinal"),
                        resultSet.getFloat("longitudFinal"),
                        resultSet.getInt("tiempoEstimado")
                );
                rutas.add(ruta);
            }
            return rutas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ruta> buscarRutasPorDescripcion(String descripcion){
        //falta hacerlo, este es para que busque rutas cuando el usuario escribe en la barra de busquedas
        return null;
    }

}
