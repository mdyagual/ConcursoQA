/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mishell Yagual Mendoza
 */
public class Respuesta {
    private String respuesta;
    private boolean correcto;

    public Respuesta(String respuesta, boolean esCorrecto) {
        this.respuesta = respuesta;
        this.correcto = esCorrecto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    @Override
    public String toString() {
        return respuesta;
    }
    
    
}
