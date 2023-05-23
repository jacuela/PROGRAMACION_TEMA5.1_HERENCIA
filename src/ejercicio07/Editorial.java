/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio07;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Editorial {
    private ArrayList<Publicacion> listaPublicaciones;

    public Editorial() {
        this.listaPublicaciones = new ArrayList();
    }
    
    
    public void addPublicacion(Publicacion p){
        this.listaPublicaciones.add(p);
    }
            
    public Publicacion obtenerPublicacion(String codigo){
        for (Publicacion p : listaPublicaciones) {
            if (p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            } 
        }
        return null;
    }
    
    public void listarPublicaciones(){
         System.out.println("========================================================="); 
        for (Publicacion p : listaPublicaciones) {
                System.out.println(p);
        }
         System.out.println("========================================================="); 
    }
    
    public void listarDetallesPublicaciones(){
         System.out.println("========================================================="); 
        for (Publicacion p : listaPublicaciones) {
                p.imprimir();
        }
         System.out.println("========================================================="); 
    }
    
    
    
    
}
