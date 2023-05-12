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
public class Triangulo extends Figura {
    
    private int base;
    private int altura; 
    
    

    public Triangulo(Dibujo dib,int x, int y, int base, int altura){
        super(dib,x,y);
        
        this.base=base;
        this.altura=altura;
        
    }
    
    
    
    @Override
    public double area() {
        double area = (base*altura)/2;
        area = Math.round(area * 10) / 10.0;
        
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = base*3;
        perimetro = Math.round(perimetro * 10) / 10.0;
        
        return perimetro;
    }

    @Override
    public void pintar() {
        
        int[] coordenadasX = new int[3];
        int[] coordenadasY = new int[3];
        
        //Relleno el array con las tres coordenadas del triangulo
        int x1=x;
        int y1=y;
        
        int x2=x+(base/2);
        int y2=y-altura;
        
        int x3=x+base;
        int y3=y;
        
        coordenadasX[0]=x1; coordenadasX[1]=x2; coordenadasX[2]=x3;
        coordenadasY[0]=y1; coordenadasY[1]=y2; coordenadasY[2]=y3;
        
        this.dibujo.ponRelleno(this.color);
        this.dibujo.dibujaPoligono(coordenadasX,coordenadasY);
        this.dibujo.dibujaTexto("Area: "+area()+"m2",x,y+20);
        this.dibujo.dibujaTexto("Perimetro: "+perimetro()+"m",x,y+40);
        
        
        
        
    }
    
}
