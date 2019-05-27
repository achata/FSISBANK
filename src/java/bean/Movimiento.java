
package bean;

import basic.bean.BasicBean;

public class Movimiento extends BasicBean{
    Cuenta cuenta;
    String strFechaMovimiento;
    Empleado empleado;
    String codTipoMovimiento;
    double importe;
    String codEmpleado;

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getStrFechaMovimiento() {
        return strFechaMovimiento;
    }

    public void setStrFechaMovimiento(String strFechaMovimiento) {
        this.strFechaMovimiento = strFechaMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCodTipoMovimiento() {
        return codTipoMovimiento;
    }

    public void setCodTipoMovimiento(String codTipoMovimiento) {
        this.codTipoMovimiento = codTipoMovimiento;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cuenta=" + cuenta 
                + ", strFechaMovimiento=" + strFechaMovimiento + ", empleado=" 
                + empleado + ", codTipoMovimiento=" + codTipoMovimiento + ", importe=" + importe + '}';
    }
    
    
}
