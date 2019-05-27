
package dao.inte;

import bean.Empleado;

public interface EmpleadoDao {
  public Empleado ValidarEmpleado(String Usuario, String Clave) throws Exception;  
}
