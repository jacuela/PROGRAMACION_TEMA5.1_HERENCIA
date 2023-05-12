/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04;

import fundamentos.ColorFig;
import fundamentos.*;

/**
 *
 * @author jacuela
 */
public abstract class Figura {
    
    protected ColorFig color;
    protected int x;
    protected int y;
    protected Dibujo dibujo;
    
    public Figura(Dibujo dib,int x, int y){
        this.x=x;
        this.y=y;
        this.dibujo=dib;
        this.color=ColorFig.amarillo;
    }
    
    
    
    public void setColor(ColorFig color){
        this.color=color;
    } 
    
    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
        
    }
    
    public abstract double area();
    
    public abstract double perimetro();
    
    public abstract void pintar();
    
    
    
}
