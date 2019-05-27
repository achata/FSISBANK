package controller;

import bean.Cuenta;
import bean.Movimiento;
import dao.impl.MovimientoDaoImp;
import dao.inte.MovimientoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/Movimiento","/modulos/movimiento/deposito"})
public class MovimientoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String accion = request.getParameter("registrarDeposito");
     
         //String uri = "";
         MovimientoDao service = new MovimientoDaoImp();
         if (accion != null && accion.equals("registrarDeposito")) {
             String mensaje = "";
             try {
                 Movimiento mov = new Movimiento();
                 //HttpSession session = request.getSession(true);
                 mov.setCodEmpleado("0004");
                 mov.setId(request.getParameter("codcuenta"));
                 mov.setImporte(Double.parseDouble(request.getParameter("monto")));
                 Boolean resultado= service.RegistrarDeposito(mov);
                 
                 if (resultado == true) {
                     mensaje = "<div class=\"alert alert-fill-success\" role=\"alert\">\n" +
                        "<i class=\"mdi material-icons\">check_circle</i>\n" +
                        "Depósito registrado con éxito.\n" +
                        "</div>";
                 }else{
                     mensaje = "<div class=\"alert alert-fill-danger\" role=\"alert\">\n" +
                        "<i class=\"mdi material-icons\">error</i>\n" +
                        "No se pudo agregar.\n" +
                        "</div>";
                 }
             } catch (Exception ex) {
                 mensaje = "<div class=\"alert alert-fill-danger\" role=\"alert\">\n" +
                        "<i class=\"mdi material-icons\">error</i>\n" +
                        "No se pudo agregar.\n" +
                        "</div>";
                 System.out.println(ex.getMessage());
             }
             request.setAttribute("mensaje", mensaje);
             RequestDispatcher dsp = request.getRequestDispatcher("/modulos/movimiento/deposito.jsp");
             dsp.forward(request, response);
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
