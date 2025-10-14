package es.tew.presentation;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("beanError")
@RequestScoped
public class BeanError implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String vistaOrigen;
    private String metodo;
    private String clase;
    private String mensajeError;


    public BeanError() {
        this.vistaOrigen = "";
        this.metodo = "";
        this.clase = "";
        this.mensajeError = "";
    }

    public void setError(String vistaOrigen, String metodo, String clase, String mensajeError) {
        this.vistaOrigen = vistaOrigen;
        this.metodo = metodo;
        this.clase = clase;
        this.mensajeError = mensajeError;
    }

    public String getVistaOrigen() {
        return vistaOrigen;
    }
    public String getMetodo() {
        return metodo;
    }

    public String getClase() {
        return clase;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    
    

    
}
