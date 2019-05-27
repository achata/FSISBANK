
package dao.impl;

import basic.mysql.Conexion;
import bean.Empleado;
import dao.inte.EmpleadoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDaoImpl implements EmpleadoDao{

    @Override
    public Empleado ValidarEmpleado(String Usuario, String Clave) throws Exception {
        Empleado empleado = new Empleado();
        Connection cn = Conexion.getConexion();
        String query= "CALL USP_LOGIN(?,?)";
        if (cn !=null) {
            try{
                CallableStatement cs = cn.prepareCall(query);
                cs.setString(1, Usuario);
                cs.setString(2, Clave);
                //cs.executeQuery();
                ResultSet rs = cs.executeQuery();
                
                    while(rs.next()){
                    empleado.setNombre(rs.getString(8));
                    empleado.setApellidoPaterno(rs.getString(6));
                    }
                    rs.close();
                    cs.close();
                
                
            }catch(SQLException e){
                System.out.println("exeption: " + e.getMessage());  
            }finally{
                try{
                    cn.close();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            } 
           
        }
       
        return  empleado;
    }
    
}
