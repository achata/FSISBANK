package dao.impl;

import basic.dao.Impl.BasicDaoImpl;
import basic.mysql.Conexion;
import bean.Cliente;
import dao.inte.ClienteDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/*extends BasicDaoImpl<Cliente>*/
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public List<Cliente> listar(Cliente obj) throws Exception{
        List<Cliente> lstCliente = new ArrayList<Cliente>();
        
        try {
            Connection cn = Conexion.getConexion();
            CallableStatement cstm = null;
            ResultSet rs = null;
            try {
                cstm = cn.prepareCall("{CALL USP_SEL_CLIENTE(?,?)}");
                cstm.setString(1, obj.getNombreCompleto());
                cstm.setString(2, obj.getDni());
                //cstm.setString(2, obj.getDni());
                //rs = cstm.executeQuery("select * from cliente");
                rs = cstm.executeQuery();
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getString(1));
                    cliente.setApellidoPaterno(rs.getString(2));
                    cliente.setApellidoMaterno(rs.getString(3));
                    cliente.setNombre(rs.getString(4));
                    cliente.setNombreCompleto(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
                    cliente.setDni(rs.getString(5));
                    cliente.setCiudad(rs.getString(6));
                    cliente.setDireccion(rs.getString(7));
                    cliente.setTelefono(rs.getString(8));
                    cliente.setEmail(rs.getString(9));
                    lstCliente.add(cliente);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                Conexion.closeResultSet(rs);
                Conexion.closeCallableStatement(cstm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCliente;
    }

    @Override
    public Boolean insertar(Cliente obj) throws Exception {
        try {
            Connection cn = Conexion.getConexion();
            CallableStatement cstm = null;
            try {
                cstm = cn.prepareCall("{ CALL USP_INS_CLIENTE(?,?,?,?,?,?,?,?,?)}");
                cstm.setString(1, obj.getApellidoPaterno());
                cstm.setString(2, obj.getApellidoMaterno());
                cstm.setString(3, obj.getNombre());
                cstm.setString(4, obj.getDni());
                cstm.setString(5, obj.getCiudad());
                cstm.setString(6, obj.getDireccion());
                cstm.setString(7, obj.getTelefono());
                cstm.setString(8, obj.getEmail());
                cstm.registerOutParameter(9, Types.INTEGER);
                cstm.execute();
                
                int retorno=0;
                retorno = cstm.getInt(9);
                System.out.println(retorno);
                if(retorno != 0){
                    return true;
                }
                    return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean actualizar(Cliente obj) throws Exception {
        try {
            Connection cn = Conexion.getConexion();
            CallableStatement cstm = null;
            try {
                cstm = cn.prepareCall("{CALL USP_UPD_CLIENTE(?,?,?,?,?,?,?,?,?,?)}");
                cstm.setString(1, obj.getId());
                cstm.setString(2, obj.getApellidoPaterno());
                cstm.setString(3, obj.getApellidoMaterno());
                cstm.setString(4, obj.getNombre());
                cstm.setString(5, obj.getDni());
                cstm.setString(6, obj.getCiudad());
                cstm.setString(7, obj.getDireccion());
                cstm.setString(8, obj.getTelefono());
                cstm.setString(9, obj.getEmail());
                cstm.registerOutParameter(10, Types.INTEGER);
                cstm.execute();
                int retorno=0;
                retorno = cstm.getInt(10);
                System.out.println(retorno);
                if(retorno != 0){
                    return true;
                }
                    return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean eliminar(Cliente obj) throws Exception {
        try {
            Connection cn = Conexion.getConexion();
            CallableStatement cstm = null;
            try {
                cstm = cn.prepareCall("{CALL USP_DEL_CLIENTE(?,?)}");
                cstm.setString(1,obj.getId());
                cstm.registerOutParameter(2, Types.INTEGER);
                cstm.execute();
                int retorno=0;
                retorno = cstm.getInt(2);
                
                if(retorno != 0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente buscarXId(String id) throws Exception {
        Cliente cliente = new Cliente();
        try {
            Connection cn = Conexion.getConexion();
            CallableStatement cstm = null;
            ResultSet rs = null;
            try {
                cstm = cn.prepareCall("CALL USP_BUSCARXID_CLIENTE");
                cstm.setString(1,id);
                
                rs = cstm.executeQuery();
                
                while(rs.next()){
                    cliente.setId(rs.getString(1));
                    cliente.setApellidoPaterno(rs.getString(2));
                    cliente.setApellidoMaterno(rs.getString(3));
                    cliente.setNombre(rs.getString(4));
                    cliente.setNombreCompleto(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
                    cliente.setDni(rs.getString(5));
                    cliente.setCiudad(rs.getString(6));
                    cliente.setDireccion(rs.getString(7));
                    cliente.setTelefono(rs.getString(8));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
            Conexion.closeCallableStatement(cstm);
            Conexion.closeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }    
}
