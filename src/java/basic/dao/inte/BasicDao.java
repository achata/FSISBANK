
package basic.dao.inte;

import java.io.Serializable;
import java.util.List;

public interface BasicDao<T extends Serializable> {
    public List<T> listar(T obj) throws Exception;
    public Boolean insertar(T obj) throws Exception;
    public Boolean actualizar(T obj) throws Exception;
    public Boolean eliminar(T obj) throws Exception;
}
