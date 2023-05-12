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
public class Piramide extends Figura {
    
    //**********
    // De cara a calcuar perímetor, hablamos de una piramide,
    // por lo que tiene forma de triangulo, pero 
    // solo puede ser de tipo equilatero o isosceles
    //**********
    
    
    private int altura;
    private int base;
    
    public Piramide(int altura) {
        super();
        this.altura = altura;
        this.base=altura*2-1;
    }
    
  
    
    

    @Override
    public double area() {
        
        //Tenemos la base y la altura 
        return (base*altura)/2;
       
        
    }

    @Override
    public double perimetro() {
        
        double baseMitad=base/2;
       
        //Tenemos la base y la altura
        //Del subtriangulo rectangulo inscrito en la piramide
        //obtengo la hipotenusa usando teorema de Pitagoras
        double hipotenusa=Math.sqrt((altura*altura)+(baseMitad*baseMitad));

        return hipotenusa+hipotenusa+this.base; 
       
    }

    @Override
    public void pintar() {
        System.out.println();
        
        for(int i = 1; i <= altura; i++){
            //Espacios en blanco
            for(int blancos = 1; blancos <= altura-i; blancos++){
                System.out.print(" ");
            }
            //Asteriscos
            for(int asteriscos = 1; asteriscos < (i*2); asteriscos++){
                System.out.print(colorRelleno + "*");
            }
            System.out.println();
        }
        
        
    }
    
    
    
    
}
