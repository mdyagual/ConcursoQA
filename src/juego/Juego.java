/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import entidades.Categoria;
import entidades.Pregunta;
import entidades.Respuesta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import util.Valor;

/**
 *
 * @author Mishell Yagual Mendoza
 */
public class Juego {
    private String fecha;
    
    //Cada que se instancie Juego debe venir con la fecha en la que se instació, definiendo a la partida como única cuando se registre en el historial
    public Juego() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        String date = formatter.format(now);        
        this.fecha = date;       
        
    }

    public String getFecha() {
        return fecha;
    }
    
    //Generacion de las 25 preguntas
    public static ArrayList<Pregunta> configurarJuego(){
        //Todas las preguntas
        ArrayList<Pregunta> preguntas=new ArrayList(); 
        int nivel=0;         
        for (int i=0; i<25; i++){            
            if(i%5==0){
                nivel++;               
            }
            Categoria c=new Categoria(nivel);        
            Pregunta p = new Pregunta(c,"Pregunta #"+(i+1));
            preguntas.add(p);
        }       
        
        return preguntas;
    }
    
    //Selección al azar de las 5 preguntas para la partida
    public static Pregunta [] preguntasPartida(ArrayList<Pregunta> p){
        ArrayList<Pregunta> pregRondas = new ArrayList();        
        
        Random r = new Random(System.currentTimeMillis());
        
        int i=r.nextInt(25);        
        Pregunta pregunta=p.get(i);
        int ingNivel=pregunta.getCategoria().getNivel();        
        ArrayList<Integer> niveles = new ArrayList();
        
        
        while(pregRondas.size()<5){
            if(!niveles.contains(ingNivel)){
                 pregRondas.add(pregunta);
                 niveles.add(ingNivel);
            }         
            
            i=r.nextInt(25);
            pregunta=p.get(i);
            ingNivel=pregunta.getCategoria().getNivel(); 
        }
        
        
        Pregunta[] preguntas = pregRondas.toArray(new Pregunta[pregRondas.size()]);
        Arrays.sort(preguntas);
        
        return preguntas;
        
    }
    
    //Dinamica del juego
    public void iniciarJuego(Jugador j, Pregunta [] p){           
        Scanner sc=new Scanner(System.in); 
        int rondas=1;
        boolean puedeContinuar=true;
        boolean seRetira=false;
        int premio = 0;
        
        while(rondas<=5 && puedeContinuar && !seRetira){
            //Inicio de rondas
            System.out.println("\nRonda #"+rondas);
            
            //Selección de pregunta: Las preguntas ya vienen seleccionadas aleatoriamiento y ordenadas de menor a mayor categoría así que solo se selecciona conforme avanzan las rondas
            Pregunta selP=p[rondas-1];
            
            //Mostrar pregunta de la categoria con el premio que le van a dar y el total que va acumulando
            System.out.println("Categoría #"+selP.getCategoria().getNivel());
            System.out.println("Premio de esta ronda: $"+Premio.dinero);
            System.out.println("Total acumulado: $"+premio);
            System.out.println(selP.getPregunta()+": XXXXXXXXXXXXXXX");
            
            //Opciones de respuesta
            ArrayList<Respuesta> selP_R=selP.getOpciones();
            
            //Aplico shuffle para que el true no salga en el mismo lugar
            Collections.shuffle(selP_R);
            
            //Mostrar las opciones de la pregunta
            for (int y=0; y<selP_R.size(); y++){
                int num=y+1;
                System.out.println(num+"."+selP_R.get(y));
                             
            }
            //Opcion de retiro
            System.out.println("5.Retirarse con $"+premio);
            
            //Ingreso de respuesta
            System.out.print("Seleccione respuesta: ");
            int res=sc.nextInt();
            
            //Definir si sigue a la otra ronda, se retira o pierde
            if(res==5){
                System.out.println("Ha decidido retirarse de la partida.");
                seRetira=true;
            }else if (selP_R.get(res-1).isCorrecto() && rondas <= 5){
                rondas++;
                System.out.println("¡Correcto!");
                premio+=Premio.dinero;
                System.out.println("Dinero ganado: $"+premio);                
                Premio.aumentarPremio();
               
            }else if (!selP_R.get(res-1).isCorrecto()){
                System.out.println("¡Incorrecto!");
                puedeContinuar=false;
            }        
        }
        
        //Definir que pasó con el jugador: ¿Ganó? ¿Perdió? ¿Se retiró?        
        
        if(rondas<5 && !puedeContinuar){
            System.out.println("Fin de la partida: ¡Perdiste!");
            j.setEstado(Valor.PERDIO_JUEGO);
            j.setPremio(0);
        }else if(seRetira){
            System.out.println("Abandonaste la partida. Dinero ganado: $"+premio);
            j.setEstado(Valor.ABANDONO_JUEGO);
            j.setPremio(premio);
        }else{
            System.out.println("Fin de la partida. ¡Ganaste! $"+premio);
            j.setEstado(Valor.GANO_JUEGO);
            j.setPremio(premio);
        }
        
        //Registrar la partida
        registrarPartida(j);
    }
    
    //Registro historico
    public void registrarPartida(Jugador j){
        File archivoHist=new File(Valor.HISTORIAL);
        FileWriter fw2=null;
        BufferedWriter bw2=null;
        try{
            boolean existsArch = archivoHist.exists();
            if(existsArch){
                //El 'true' indica que se escribirá para agregar más líneas al archivo existente
                fw2=new FileWriter(archivoHist,true);
            }else{
                fw2=new FileWriter(archivoHist);
            }
             
            bw2=new BufferedWriter(fw2);            
            
            bw2.write(j.toString()+"\n");
            bw2.flush();                      
            System.out.println("Archivo actualizado!");
            
        }catch(IOException ex){
            System.out.println(ex.toString());
        }finally{
            try {
                bw2.close();
            } catch (IOException ex) {
               System.out.println(ex+": No existe el archivo");
            }
        }
        
    }
}
