/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio03;

/**
 *
 * @author jacuela
 */
public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(int lado) {
        super();
        this.lado = lado;
    }
    
    
    @Override
    public double area() {
        return lado*lado;
    }

    @Override
    public double perimetro() {
        return lado+lado+lado+lado;
    
    }

    @Override
    public void pintar() {
        System.out.println();
        
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print(colorRelleno+"* ");
            }
            System.out.println("");
        }
        
        
        
    }
    
    
    
    
    
    
    
}
