/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concursoqa;

import entidades.Pregunta;
import java.util.ArrayList;
import java.util.Scanner;
import juego.Juego;
import juego.Jugador;
import juego.Premio;

/**
 *
 * @author Mishell Yagual Mendoza
 */
public class ConcursoQA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        start();       
        
    }
    
    public static void start(){
        Scanner sc= new Scanner(System.in);
        ArrayList<Pregunta> conjPreguntas = new ArrayList();
        Pregunta [] prePartida = null;
        String op="-1";
        boolean hayConfig=false;
        while(!op.equals("3")){
            System.out.println("Concurso de preguntas y respuestas - Por Mishell Yagual~");
            System.out.println("1. Configurar");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            op=sc.nextLine();
            switch (op){
                case "1":
                    System.out.println("Configurando juego...");
                    conjPreguntas=Juego.configurarJuego();
                    prePartida=Juego.preguntasPartida(conjPreguntas);
                    System.out.println("¡Juego configurado!");
                    hayConfig=true;
                    break;
                case "2":
                    if(hayConfig){
                        System.out.println("Iniciando partida...");
                        Juego nuevoJuego = new Juego();         
                        System.out.println("El nickname ingresado lo identificará durante toda la partida");
                        System.out.print("Ingrese su nickname: ");
                        String nickname = sc.nextLine();
                        Jugador j = new Jugador(nuevoJuego.getFecha(),nickname);
                        nuevoJuego.iniciarJuego(j, prePartida);
                        op="3";
                    }else{
                        System.out.println("Configure el juego en la opción 1.");
                    }

                    break;
                case "3":
                    System.out.println("Gracias por jugar~");
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");

            }

        }
    }
}
