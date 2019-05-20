
package bean;

import basic.bean.BasicBean;

public class Cuenta extends BasicBean{
    String codMoneda;
    String codSucursal;
    Empleado empleado;
    Cliente cliente;
    double saldo;
    String strFechaCreacion;

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getStrFechaCreacion() {
        return strFechaCreacion;
    }

    public void setStrFechaCreacion(String strFechaCreacion) {
        this.strFechaCreacion = strFechaCreacion;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "codMoneda=" + codMoneda 
                + ", codSucursal=" + codSucursal + ", empleado=" + empleado + ", cliente=" 
                + cliente + ", saldo=" + saldo + ", strFechaCreacion=" + strFechaCreacion + '}';
    }
    
    
}
