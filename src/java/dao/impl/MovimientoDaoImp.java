package dao.impl;

import basic.mysql.Conexion;
import bean.Empleado;
import bean.Movimiento;
import dao.inte.MovimientoDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MovimientoDaoImp implements MovimientoDao{

    @Override
    public Boolean RegistrarDeposito(Movimiento mov) throws Exception {
        Boolean result = false;
        Connection cn = Conexion.getConexion();
        CallableStatement cs = null;
        try{
            String query = "CALL USP_DEPOSITO(?,?,?)";
            cs = cn.prepareCall(query);
            cs.setString(1, mov.getId());
            cs.setDouble(2, mov.getImporte());
            cs.setString(3, mov.getCodEmpleado());
            int rt = cs.executeUpdate();
            if (rt == 0) {
                throw new SQLException();
            }
            result = true;
            cs.close();
            
        }catch(SQLException e){
            System.out.println("ups!!!"+ e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    
}
