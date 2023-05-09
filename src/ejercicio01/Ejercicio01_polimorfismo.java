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
public class Ejercicio01_polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //*********************************************
        //       NO ES NECEARIO DEFINIR LAS VARIABLES
        //       PUES COMO NO VOY A USARLAS, PUEDO CREAR
        //       LOS OBJETOS DIRECTAMENTE PARA METERLOS AL ARRAYLIST
        //**********************************************
        //Empleado empleado=new Empleado("1111A","Alicia Camacho");
        //Contable contable=new Contable("2222A", "Marta Grey");
        //Director director=new Director("3333A", "Celia Blue",217);
      
        
        ArrayList<Empleado> listaEmpleados=new ArrayList();
        listaEmpleados.add(new Empleado("1111A","Alicia Camacho"));
        listaEmpleados.add(new Contable("2222A", "Marta Grey"));
        listaEmpleados.add(new Director("3333A", "Celia Blue",217));
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
            listaEmpleados.get(i).setHorasExtra(5);
            System.out.println(listaEmpleados.get(i));
            System.out.println("Sueldo: "+listaEmpleados.get(i).calcularSueldo());
            
            if (listaEmpleados.get(i) instanceof Contable ){
                Contable uncontable=(Contable)listaEmpleados.get(i);
                uncontable.contabilizar();
            }
            if (listaEmpleados.get(i) instanceof Director ){
                Director undirector=(Director)listaEmpleados.get(i);
                undirector.analizarDatos();
            }
            
            System.out.println("");
        }
        
        
        
        
        
    }
    
}
