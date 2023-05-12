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
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Rectangulo r=new Rectangulo(8,3);
        //r.setColor(TipoColor.ROJO);
        r.pintar();
        System.out.printf("Area:%7.2f     Perimetro:%.2f\n",r.area(),r.perimetro());
        
       
        Cuadrado c=new Cuadrado(3);
        c.setColor(TipoColor.AZUL);
        c.pintar();
        System.out.printf("Area:%7.2f     Perimetro:%.2f\n",c.area(),c.perimetro());
            
        Piramide p=new Piramide(4);
        p.setColor(TipoColor.VERDE);
        p.pintar();
        System.out.printf("Area:%7.2f     Perimetro:%.2f\n",p.area(),p.perimetro());
        
    }
    
}
