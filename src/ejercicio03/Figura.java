/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;


enum TipoColor{
    NEGRO,ROJO,VERDE,AZUL
    
}

/**
 *
 * @author jacuela
 */
public abstract class Figura {
    protected String colorRelleno;
    
    static final String COLOR_NEGRO="\033[30m";
    static final String COLOR_ROJO="\033[31m";
    static final String COLOR_VERDE="\033[32m";
    static final String COLOR_AZUL="\033[34m";
    
    public Figura() {
        this.colorRelleno = COLOR_NEGRO;
       
    }

    public void setColor(TipoColor tipo) {
        
        switch(tipo){
        case VERDE :
            colorRelleno = "\033[32m";
            //colorRelleno = COLOR_VERDE;
            break;
        case AZUL:
            colorRelleno = COLOR_AZUL;
            break;
        case ROJO:
            colorRelleno = COLOR_ROJO;
            break;
        case NEGRO:
            colorRelleno = COLOR_NEGRO;
            break;
        }
        
        
       
    }
    
    public abstract double area();
    
    public abstract double perimetro();
    
    public abstract void pintar();
    
    
}
