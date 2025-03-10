/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio09;

/**
 *
 * @author juan.antonio
 */
public abstract class Publicacion {
    protected String titulo;
    protected String autor;
    
    Publicacion(String titulo, String autor){
        this.titulo=titulo;
        this.autor=autor;
    } 
    
    public abstract void imprimir();
    
}
