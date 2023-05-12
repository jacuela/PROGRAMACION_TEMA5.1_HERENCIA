/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Ejercicio03_polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Figura> listaFiguras=new ArrayList();
        
        Figura figura;
        
        figura=new Rectangulo(8,3);
        figura.setColor(TipoColor.ROJO);
        listaFiguras.add(figura);
        
        figura=new Cuadrado(3);
        figura.setColor(TipoColor.AZUL);
        listaFiguras.add(figura);
       
        figura=new Piramide(4);
        figura.setColor(TipoColor.VERDE);
        listaFiguras.add(figura);
        
        for (Figura f : listaFiguras) {
            f.pintar();
            System.out.printf("Area:%7.2f     Perimetro:%.2f\n",f.area(),f.perimetro());
        }
        
        
       
    }
    
}
