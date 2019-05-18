
package basic.bean;

import java.io.Serializable;

public class BasicBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String situacion;
    private String situacionNombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getSituacionNombre() {
        return situacionNombre;
    }

    public void setSituacionNombre(String situacionNombre) {
        this.situacionNombre = situacionNombre;
    }

    @Override
    public String toString() {
        return "BasicBean{" + "id=" + id + ", situacion=" + situacion + ", situacionNombre=" + situacionNombre + '}';
    }
    
}
