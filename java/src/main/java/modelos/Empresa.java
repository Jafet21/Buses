/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Felipe
 */

@Data
@Builder
public class Empresa {
  private int id;
  private String nombre;
  private String telefono;
  private String correo;
}
