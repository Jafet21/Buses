package modelos;

import lombok.Builder;
import lombok.Data;

//Estas anotaciones generan metodos de get y set automaticamente y un "Builder" para construir objetos facilmente, ver ejemplos en controladores y repositorios
@Data
@Builder
public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;
}
