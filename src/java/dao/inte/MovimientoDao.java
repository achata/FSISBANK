package dao.inte;

import bean.Movimiento;

public interface MovimientoDao {
    public Boolean RegistrarDeposito(Movimiento movimiento) throws Exception;
    
}
