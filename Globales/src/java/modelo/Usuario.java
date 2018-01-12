/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Felipe
 */
public class Usuario {

    private String nombre;
    private int identificacion;
    private String apellidos;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, int identificacion, String apellidos, String correo, String contraseña) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.identificacion = 0;
        this.apellidos = "";
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
