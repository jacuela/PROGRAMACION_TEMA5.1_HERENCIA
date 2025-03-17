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
public class Rectangulo extends Figura {

    private int ladoLargo;
    private int ladoCorto;

    public Rectangulo(int ladoLargo, int ladoCorto) {
        super();
        this.ladoLargo = ladoLargo;
        this.ladoCorto = ladoCorto;
        
    }
    
    
    @Override
    public double area() {
        return ladoLargo*ladoCorto;
    }

    @Override
    public double perimetro() {
        return ladoLargo+ladoLargo+ladoCorto+ladoCorto;
    
    }

    @Override
    public void pintar() {
        System.out.println("");
       
        for (int i = 0; i < ladoCorto; i++) {
            for (int j = 0; j < ladoLargo; j++) {
                System.out.print(this.colorRelleno+"* ");
            }
            System.out.println("");
        }
        
        
        
    }
    
    
    
    
    
    
}
