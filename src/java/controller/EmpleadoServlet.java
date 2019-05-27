package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Empleado;
import dao.impl.EmpleadoDaoImpl;
import dao.inte.EmpleadoDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
@WebServlet({"/Empleado","/index"})
public class EmpleadoServlet extends HttpServlet {
   
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("login");
        if (accion != null && accion.equals("Ingresar")) {
            EmpleadoDao daoemp = new EmpleadoDaoImpl();
            try{
                String usuario = request.getParameter("usuario");
                String clave =request.getParameter("clave");
                if (!usuario.equals("") && !clave.equals("")) {
                    Empleado empleado = daoemp.ValidarEmpleado(usuario, clave);
                    if (empleado == null) {
                         request.setAttribute("mensaje", "<div class=\"alert alert-fill-danger\" role=\"alert\">\n" +
                    "<i class=\"material-icons\">error</i>\n" +
                    "Oh! Usuario o clave incorrectos.\n" +
                    "</div>");
                         RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
                         dsp.forward(request, response); 
                    } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("nombre", empleado.getNombre());
                    session.setAttribute("apellidop", empleado.getApellidoPaterno());
                    //request.setAttribute("datosEmpleado", empleado);
                    RequestDispatcher dsp = request.getRequestDispatcher("/modulos/mantenimiento/cliente.jsp");
                    dsp.forward(request, response);  
                    }
                   
                }
               
                
            }catch(Exception e){
                System.out.println(e.getMessage());
                    request.setAttribute("mensaje", "<div class=\"alert alert-fill-danger\" role=\"alert\">\n" +
                    "<i class=\"material-icons\">error</i>\n" +
                    "Oh! Se ha producido un error :( .\n" +
                    "</div>");
                         RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
                         dsp.forward(request, response);
            }
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
