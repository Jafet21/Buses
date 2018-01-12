/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Usuario;
import Conexion.RepositorioUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.JsonConverter;

/**
 *
 * @author Felipe
 */
public class Registro_Usuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {

            RepositorioUsuarios repUsuario = new RepositorioUsuarios();
            Usuario usuario;
            String json;

            //**********************************************************************
            //se consulta cual accion se desea realizar
            //**********************************************************************
            String accion = request.getParameter("accion");

            switch (accion) {

                case "registrarUsuario":
                    usuario = new Usuario(request.getParameter("nombreUsuario"),
                            Integer.parseInt(request.getParameter("identificacion")),
                            request.getParameter("apellidos"),
                            request.getParameter("correo"),
                            request.getParameter("contrasena"));
                    
                    if (repUsuario.getUsuario(Integer.parseInt(request.getParameter("identificacion"))) == null) {
                        repUsuario.insertarUsuario(usuario);
                        out.print("registrado correctamente");
                    } else {
                        out.print("Errror al momento de registar");
                    }
                    break;

                default:
                    out.print("No define accion");
                    break;
            }

        } catch (NumberFormatException e) {
            out.print(JsonConverter.convertToString(e));
        } catch (Exception e) {
            out.print(JsonConverter.convertToString(e));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
