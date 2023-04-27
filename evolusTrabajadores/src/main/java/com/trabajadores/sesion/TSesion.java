package com.trabajadores.sesion;

import java.util.Date;

public class TSesion {

    public String usuario;

    public String clave;

    public Date modificacion;

    public Date creacion;

    public TSesion(String usuario, String clave, Date modificacion, Date creacion) {
        super();
        this.usuario = usuario;
        this.clave = clave;
        this.modificacion = modificacion;
        this.creacion = creacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getModificacion() {
        return modificacion;
    }

    public void setModificacion(Date modificacion) {
        this.modificacion = modificacion;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

}
