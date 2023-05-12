/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04;

import fundamentos.*;

/**
 *
 * @author jacuela
 */
public class Rectangulo extends Figura {

    private int ladoLargo;
    private int ladoCorto;
    
    
    public Rectangulo(Dibujo dib,int x, int y, int ladoLargo, int ladoCorto){
        super(dib,x,y);
        this.ladoLargo=ladoLargo;
        this.ladoCorto=ladoCorto;
        
    }
    
    
    @Override
    public double area() {
        double area = ladoLargo*ladoCorto;
        area = Math.round(area * 10) / 10.0;
        
        return area;
     }

    @Override
    public double perimetro() {
        double perimetro = ladoLargo+ladoLargo+ladoCorto+ladoCorto;
        perimetro = Math.round(perimetro * 10) / 10.0;
        
        return perimetro;
    }

    @Override
    public void pintar() {
        this.dibujo.ponRelleno(this.color);
        this.dibujo.dibujaRectangulo(x, y, x+ladoLargo, y+ladoCorto);
        this.dibujo.dibujaTexto("Area: "+area()+"m2",x,y-40);
        this.dibujo.dibujaTexto("Perimetro: "+perimetro()+"m",x,y-20);
        
            
       
    }
    
    
}
