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
public class Categoria{
    private int nivel;

    public Categoria(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    @Override
    public String toString() {
        return "Categoria{" + "nivel=" + nivel + '}';
    }

    
    
    
    
    
}
