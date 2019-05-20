
package controller;

import dao.impl.ClienteDaoImpl;
import dao.inte.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author pc
 */
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    
    //POLIMORFISMO
    public ClienteDao clienteDao = new ClienteDaoImpl();

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String operacion = request.getParameter("operacion");
        
        if(operacion.equals("clientes")){
            this.listar(request, response);
        }else if(operacion.equals("newCliente")){
            this.insertar(request, response);
        }else if(operacion.equals("buscarXId")){
            this.buscarXId(request, response);
        }else if(operacion.equals("editCliente")){
            this.editar(request, response);
        }else if(operacion.equals("eliminar")){
            this.eliminar(request, response);
        }
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listadoCliente = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        if(nombre == null || dni == null){
            cliente.setNombreCompleto("");
            cliente.setDni("");
        }else{
            cliente.setNombreCompleto(nombre);
            cliente.setDni(dni);
        }
        try {
            listadoCliente= this.clienteDao.listar(cliente);
            request.setAttribute("listadoCliente", listadoCliente);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modulos/mantenimiento/cliente.jsp");  
            rd.forward(request, response);
            //response.sendRedirect("/modulos/mantenimiento/cliente.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        Cliente cliente = new Cliente();
        Boolean bit = null;
        /*String id = request.getParameter("id");
        if(id != null){
            this.editar(request,response);
            return;
        }*/
        try {
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellidoPaterno(request.getParameter("apePat"));
            cliente.setApellidoMaterno(request.getParameter("apeMat"));
            cliente.setDni(request.getParameter("dni"));
            cliente.setCiudad(request.getParameter("ciudad"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setEmail(request.getParameter("email"));
            bit = this.clienteDao.insertar(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bit = false;
        }
        
        if(bit && bit != null){
            /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/modulos/mantenimiento/cliente.jsp");  
            rd.forward(request, response);*/
            //response.sendRedirect(request.getContextPath()+"/ClienteServlet?operacion=clientes");
            this.listar(request, response);
        }else{
            System.out.println("NO SE PUDO INSERTAR");
        }
    }
    
    private void buscarXId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Cliente cliente = new Cliente();
        try {
         cliente = this.clienteDao.buscarXId(request.getParameter("idCliente"));   
         request.setAttribute("unCliente", cliente);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/modulos/mantenimiento/cliente.jsp");  
         rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Cliente cliente = new Cliente();
        Boolean bit = null;
        
        try {
            cliente.setId(request.getParameter("idCliente"));
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellidoPaterno(request.getParameter("apePat"));
            cliente.setApellidoMaterno(request.getParameter("apeMat"));
            cliente.setDni(request.getParameter("dni"));
            cliente.setCiudad(request.getParameter("ciudad"));
            cliente.setDireccion(request.getParameter("direccion"));
            cliente.setTelefono(request.getParameter("telefono"));
            cliente.setEmail(request.getParameter("email"));
            bit = this.clienteDao.actualizar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void eliminar (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Cliente cliente = new Cliente();
        Boolean bit = null;
        try {
            cliente.setId(request.getParameter("idCliente"));
            bit = this.clienteDao.eliminar(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bit = false;
        }
        
        if(bit && bit != null){
            /*RequestDispatcher rd = getServletContext().getRequestDispatcher("/modulos/mantenimiento/cliente.jsp");  
            rd.forward(request, response);*/
            this.listar(request, response);
        }else{
            System.out.println("NO SE PUDO ELIMINAR");
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
