package basic.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
/*private static GestionBD instancia=null;  
public Connection cn=null;  /
private Statement st=null;*/

//Metodo estatico - Consigue una nueva instancia si es que la instancia no existe
//Si la instancia existiera devuelve la que existe. (Se optimiza el uso de la memoria)
/*public static GestionBD getInstancia() throws Exception {
    if(instancia==null){
        instancia=new GestionBD();
    }
    return instancia;
    }*/

//Metodo constructor - ocurre automaticamente cada vez que se instancia
public static Connection getConexion() throws Exception {
    //registrar el driver JDBC
    try {
        String usuario="root";
        String password="";
        String servidor="localhost";
        String puerto="3306";
        String basedatos="eurekabank";
        String url="jdbc:mysql://"+servidor+":"+puerto+"/"+basedatos;
        Class.forName("com.mysql.jdbc.Driver");
        //2da fase - Establecer la conexion con la base de datos
        Connection cn=DriverManager.getConnection(url,usuario,password);
        return cn;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public static void closeResultSet(ResultSet rs) {
    if (rs!=null) {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public static void closeCallableStatement(CallableStatement cstm) { // cambiar a Callable luego
    if (cstm!=null) {
        try {
            cstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Este metodo ejecutará los comandos select
/*public ResultSet ejecutarConsulta(String sql) throws Exception {
    st=cn.createStatement();
    ResultSet rs=null;
    rs=st.executeQuery(sql);
    return rs;
}*/
//Este método ejecutará los comandos de actualización
/*public void ejecutarActualizacion(String sql) throws Exception {
st=cn.createStatement();
st.executeUpdate(sql);
}*/
}
