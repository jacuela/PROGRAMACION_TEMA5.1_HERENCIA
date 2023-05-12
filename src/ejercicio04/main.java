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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        
        //**********  PRUEBA SIN PINTAR LAS FIGURAS
        //El primer parámetro de la figura lo ponemos a null. 
        
//        Figura figura1=new Rectangulo(null,30,30,150,20);
//        Figura figura2=new Circulo(null,100,100,50);
//        
//        
//        System.out.println("Figura1: RECTANGULO");
//        System.out.println("El area es:"+figura1.area()+"m2");
//        System.out.println("El perimetro es:"+figura1.perimetro()+"m");
//        
//        System.out.println("\n\n\n");
//        
//        System.out.println("Figura2: CIRCULO");
//        System.out.println("El area es:"+figura2.area()+"m2");
//        System.out.println("El perimetro es:"+figura2.perimetro()+"m");
   
        
    
        //**********  PRUEBA USANDO LA LIBRERIA fundamentos.jar
        Dibujo dib=new Dibujo("Prueba de dibujo",800,600);
        dib.ponLetra(20);
        
        Figura rectangulo=new Rectangulo(dib,100,100,150,100);
        rectangulo.pintar();
        
        
        Figura circulo=new Circulo(dib,400,300,100);
        circulo.setColor(ColorFig.rojo);
        circulo.pintar();
        
        
        Figura triangulo=new Triangulo(dib,550,200,150,150);
        triangulo.setColor(ColorFig.azul);
        triangulo.pintar();
        
        
        //Esto es para que el lienzo no se cierre. 
        dib.espera();
        System.exit(0);
        
        
    }
    
}
