
package Controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.Persona;
import modelo.Validar;
import javax.swing.JOptionPane;

public class Controlador extends HttpServlet {

 //Creamos instancias de Validar y Persona
 Validar valid = new Validar();
 Persona p = new Persona();
 Validar validar = new Validar();
 RequestDispatcher dispatcher = null;
 List<Persona> listarpersonas  = validar.listarpersonas();
 int r;
         
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String accion = request.getParameter("accion");
     switch (accion) {
         case "Ingresar":
             String nom = request.getParameter("txtnombre");
             String correo = request.getParameter("txtemail");
             p.setNom(nom);
             p.setCorreo(correo);
             r=valid.validar(p);
             if(r >= 1){
                 request.getSession().setAttribute("nom",nom);
                 request.getSession().setAttribute("correo",correo);
                 
                 request.getRequestDispatcher("principal.jsp").forward(request, response);
             }else{
                 JOptionPane.showMessageDialog(null, "Usuario no registrado");
                 request.getRequestDispatcher("index.jsp").forward(request, response);
             }break;
         case "Guardar":
             String nomnew = request.getParameter("newnombre");
             String correonew = request.getParameter("newemail");
             p.setNom(nomnew);
             p.setCorreo(correonew);
             r=valid.validar(p);
             if(r >= 1){
                 System.out.println("Usuario ya existe");
                 JOptionPane.showMessageDialog(null, "Usuario ya existe");
                 /*request.getRequestDispatcher("principal.jsp").forward(request, response);*/
             }else{
                 r=valid.guardar(p);
                 JOptionPane.showMessageDialog(null, "Usuario guardado");
                 System.out.println("Usuario Guardado");
                 request.getRequestDispatcher("index.jsp").forward(request, response);
             }
             break;
         case "eliminar":
             dispatcher = request.getRequestDispatcher("novedades.jsp");
             //List<Persona> listarpersonas  = validar.listarpersonas();
             request.setAttribute("lista", listarpersonas);
             dispatcher.forward(request, response);
             break;
         case "eliminado":    
             int res = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el usuario?","Eliminar Usuario", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
             String mensaje = "";
            switch (res) {
            case 0:
                int id = Integer.parseInt(request.getParameter("id"));
                validar.eliminar(id);
                mensaje = "Eliminado..."; 
                break;
            case 1:
                mensaje = "Acción rechazada..."; 
                break;
            case 2:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            }
              JOptionPane.showMessageDialog(null, mensaje);
              request.getRequestDispatcher("index.jsp").forward(request, response);
             break;
         case "modificar":
             int id = Integer.parseInt(request.getParameter("id"));
             JOptionPane.showMessageDialog(null, id);
             Persona persona = validar.mostrarPersona(id);
             request.setAttribute("persona", persona);
             request.getRequestDispatcher("actualizaPersona.jsp").forward(request, response);
             //dispatcher = request.getRequestDispatcher("actualizaPersona.jsp");
             
             break;
         default:
             request.getRequestDispatcher("index.jsp").forward(request, response);
             break;
     }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
