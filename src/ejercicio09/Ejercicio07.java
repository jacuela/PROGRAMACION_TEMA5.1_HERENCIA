/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        LocalDate unaFecha;
        
        
        ArrayList<Publicacion> lista=new ArrayList();
        
        Libro libro1=new Libro("EL HOBBIT","Tolkien","XA-123");
        lista.add(libro1);
        
        Libro libro2=new Libro("1984","G.Oswell","AA-458");
        lista.add(libro2);
        
        libro2.prestar();
        
        unaFecha=LocalDate.parse("01/01/2021", dtf);
        Revista revista1=new Revista("HOLA","EdicionesB","45-DF",unaFecha);
        lista.add(revista1);
        revista1.añadirNumero();
        revista1.añadirNumero();
        
        
        unaFecha=LocalDate.parse("01/01/2021", dtf);
        Revista revista2=new Revista("TODO CONSOLAS","EdicionesZ","65-AA",unaFecha);
        revista2.setPeriocidad(TipoPeriocidad.QUINCENAL);
        lista.add(revista2);
        revista2.añadirNumero();
        revista2.añadirNumero();
        revista2.añadirNumero();
        revista2.añadirNumero();
       
        
        //Imprimir todas las publicaciones
        System.out.println("======================================");
        for (Publicacion p : lista) {
            p.imprimir();
            System.out.println("---------------------------------------");
        }
        System.out.println("======================================");
        
        
        
        
        
        
    }
    
}
