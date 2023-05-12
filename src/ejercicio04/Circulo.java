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
public class Circulo extends Figura {

    private int radio;
    
    public Circulo(Dibujo dib,int x, int y, int radio){
        super(dib,x,y);
        
        this.radio=radio;
        
    }
    
    @Override
    public double area() {
        
        double area = radio*radio*Math.PI;
        area = Math.round(area * 10) / 10.0;
        
        return area;
        
    }

    @Override
    public double perimetro() {
        
        double perimetro = 2*radio*Math.PI;
        perimetro = Math.round(perimetro * 10) / 10.0;
        
        return perimetro;
    }

    @Override
    public void pintar() {
   
        this.dibujo.ponRelleno(this.color);
        this.dibujo.dibujaElipse(x-radio, y-radio, x+radio, y+radio);
        
        //Imprimir area y perimetro
        this.dibujo.dibujaTexto("Area: "+area()+"m2",x-radio,y+(radio+20));
        this.dibujo.dibujaTexto("Perimetro: "+perimetro()+"m",x-radio,y+20+(radio+20));
        
        
            
    
    }
    
    
    
    
}




