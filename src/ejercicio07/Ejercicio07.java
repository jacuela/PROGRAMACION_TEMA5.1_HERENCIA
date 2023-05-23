/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07;

import ejercicio09.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Ejercicio07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner teclado = new Scanner(System.in);
        LocalDate unaFecha;
        int opcion;
        boolean salir=false;
        String codigo;
        Publicacion p;
        
        
        //*************** inicializacion de datos *****************************
        Editorial editorialArcas = new Editorial();
        
        Libro libro1=new Libro("L-100","EL RESPLANDOR","88888888Z",10);
        editorialArcas.addPublicacion(libro1);
        
        Libro libro2=new Libro("L-212","JAVA para todos","48484400A",5);
        editorialArcas.addPublicacion(libro2);
        libro2.prestar();
        
        unaFecha=LocalDate.parse("01/01/2023", dtf);
        Revista revista1=new Revista("R-45","HOLA","33445566X",unaFecha);
        editorialArcas.addPublicacion(revista1);
        revista1.añadirNumero();
        revista1.añadirNumero();
        
        unaFecha=LocalDate.parse("01/01/2023", dtf);
        Revista revista2=new Revista("R-65","TODO CONSOLAS","33445566X",unaFecha);
        revista2.setPeriocidad(TipoPeriocidad.QUINCENAL);
        editorialArcas.addPublicacion(revista2);
        revista2.añadirNumero();
        revista2.añadirNumero();
        revista2.añadirNumero();
        revista2.añadirNumero();
        //*************** fin inicializacion de datos *****************************
        
        
        //Menu principal
        while(!salir){
           
           System.out.println("\n\n\n\n EJERCICIO 7 - PUBLICACIONES");
           editorialArcas.listarPublicaciones();
           
           System.out.println("1. Añadir libro");
           System.out.println("2. Añadir revista");
           System.out.println("3. Prestar/devolver libro");
           System.out.println("4. Sacar nuevo numero de revista");
           System.out.println("5. Detalles de publicacion");
           System.out.println("6. Salir");
           System.out.print("Elige una opcion >");
           opcion = Integer.parseInt(teclado.nextLine());
            
           switch(opcion){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    System.out.print("Codigo del LIBRO:");
                    codigo = teclado.nextLine();
                    p = editorialArcas.obtenerPublicacion(codigo);
                    if (p instanceof Libro){
                        Libro libro = (Libro)p;
                        if (libro.estaPrestado()) libro.devolver();
                        else libro.prestar();
                    }
                    else{
                        System.out.println("ERROR: el codigo no es de un libro");
                    }
                    break;

                case 4:
                    System.out.print("Codigo de la REVISTA:");
                    codigo = teclado.nextLine();
                    p = editorialArcas.obtenerPublicacion(codigo);
                    if (p instanceof Revista){
                        Revista revista = (Revista)p;
                        revista.añadirNumero();
                    }
                    else{
                        System.out.println("ERROR: el codigo no es de una revista");
                    }
                    break;

                case 5:
                    System.out.print("Codigo de la publicacion [INTRO para todas]:");
                    codigo = teclado.nextLine();
                    if (codigo.equals("")){
                        editorialArcas.listarDetallesPublicaciones();
                    }else{
                        p = editorialArcas.obtenerPublicacion(codigo);
                        System.out.println("");
                        p.imprimir();
                    }
                    break;

                case 6:
                   salir=true;
                   break;

                default:
                   System.out.println("Solo números entre 1 y 6");
           }
           
           if (opcion!=6) pulseIntroParaContinuar();
            
       } //fin menu
        
    }
    
    private static void pulseIntroParaContinuar(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\033[34m        Pulse INTRO para continuar....\033[30m");
        String tecla=scn.nextLine();
                   
        
    }
    
    
}
