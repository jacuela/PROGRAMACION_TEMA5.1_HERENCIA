/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07;

import ejercicio09.*;

/**
 *
 * @author juan.antonio
 */
public class Libro extends Publicacion{
    private int num_edicion;
    private boolean prestado;
    
    Libro(String codigo, String titulo, String dni_autor, int edicion){
        super(codigo,titulo,dni_autor);
        this.num_edicion=edicion;
        this.prestado=false;
        
    }
    
    @Override
    public String toString(){
        String cadena;
        if (prestado)
            cadena=String.format("LIBRO   [%5s] %15s %2dª edicion(\033[31mPRESTADO\033[30m)",this.codigo,this.titulo,this.num_edicion);
        else
            cadena=String.format("LIBRO   [%5s] %15s %2dª edicion(DISPONIBLE)",this.codigo,this.titulo,this.num_edicion);
        
        return cadena;
    }

    @Override
    public void imprimir() {
        System.out.println("");

        System.out.println("Detalles del LIBRO");
        System.out.println("==================");
        System.out.println("Codigo:"+this.codigo);
        System.out.println("Titulo:"+this.titulo);
        System.out.println("Numero edicion:"+this.num_edicion);
        System.out.println("Nombre autor:"+this.nombre_autor);
        System.out.println("Pais autor:"+this.pais_autor);
        if (prestado)
            System.out.println("ESTADO: \033[31mPRESTADO\033[30m");
        else
            System.out.println("ESTADO: DISPONIBLE");
            
    }

    
    public void prestar() {
        this.prestado=true;
    }

    
    public void devolver() {
        this.prestado=false;
    }

    public boolean estaPrestado(){
        return this.prestado;
    }
    

    
}
