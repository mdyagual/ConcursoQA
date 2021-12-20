/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Mishell Yagual Mendoza
 */
public class Pregunta implements Comparable<Pregunta> {
    private Categoria categoria;
    private String pregunta;
    private ArrayList<Respuesta> opciones;
    
    public Pregunta(Categoria categoria, String pregunta) {
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.opciones = new ArrayList();
        generarOpciones(opciones);
        
    }    
    private void generarOpciones(ArrayList<Respuesta> r){
        r.add(new Respuesta("True",true));
        r.add(new Respuesta("False",false));
        r.add(new Respuesta("False",false));
        r.add(new Respuesta("False",false));
        
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<Respuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Respuesta> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return pregunta;
    }

    @Override
    public int compareTo(Pregunta p) {
        return this.categoria.getNivel() > p.categoria.getNivel() ? 1 : this.categoria.getNivel() < p.categoria.getNivel() ? -1 : 0;
    }
    
    
    
}
