package modelos;

import java.util.Date;

public class Comentario {

    public Comentario() {
    }

    public Comentario(int id, String nombreUsuarioC, String nombreRuta, String comentario, String fecha) {
        this.id = id;
        this.nombreUsuarioC = nombreUsuarioC;
        this.nombreRuta = nombreRuta;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuarioC() {
        return nombreUsuarioC;
    }

    public void setNombreUsuarioC(String nombreUsuarioC) {
        this.nombreUsuarioC = nombreUsuarioC;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
    private int id;
    private String nombreUsuarioC;
    private String nombreRuta;
    private String comentario;
    private String fecha;
}
