/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01;

import java.util.ArrayList;

/**
 *
 * @author jacuela
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        //******** OPCION 1 ***********************
        //Opción donde nos creamos varios objetos de las
        //tres clases.
        //Usartemos sout para imprimir los objetos, puesto
        //que hemos definido el método toString()
        
        Empleado empleado=new Empleado("1111A","Alicia Camacho");
        Contable contable=new Contable("2222A","J.L.Abalos");
        Director director=new Director("3333A","Ana Botín",204);
        
        //Añadimos horas extra
        empleado.setHorasExtra(5);
        contable.setHorasExtra(5);
        director.setHorasExtra(5);
        
        //Imprimo
        System.out.println(empleado);
        System.out.println("SUELDO:"+empleado.calcularSueldo());
        System.out.println("");
        System.out.println(contable);
        System.out.println("SUELDO:"+contable.calcularSueldo());
        contable.contabilizar();
        System.out.println("");
        System.out.println(director);
        System.out.println("SUELDO:"+director.calcularSueldo());
        director.analizarDatos();
        
    }
    
    
    
}
