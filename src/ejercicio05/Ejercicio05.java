/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

import java.util.ArrayList;

/**
 *
 * @author jacuela
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Vehiculo> listaVehiculos=new ArrayList();
        
        Turismo turismo1=new Turismo("1111FFF","PEUGEOT 308");
        Turismo turismo2=new Turismo("2222AAA","SEAT IBIZA",10000);
        Camion camion1=new Camion("3333GGG","VOLVO 500");
        Camion camion2=new Camion("5555BBB","SCANIA 550",100000);
        
        listaVehiculos.add(turismo1);
        listaVehiculos.add(turismo2);
        listaVehiculos.add(camion1);
        listaVehiculos.add(camion2);
        
        for (Vehiculo v : listaVehiculos) {
             if (v instanceof Camion){
                 System.out.print("[ CAMION]  ");
                 System.out.println(v);
             }
                  
               if (v instanceof Turismo){
                 System.out.print("[TURISMO]  ");
                 System.out.println(v);
             }
        }
        
        turismo1.avanzar(20000);
        turismo2.avanzar(30000);
        camion1.avanzar(20000);
        camion2.avanzar(60000);
        
        
       
        
    }
    
}
