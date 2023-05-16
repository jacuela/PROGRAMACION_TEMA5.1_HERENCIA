/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import ejercicio06.*;

/**
 *
 * @author juan.antonio
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Empresa.añadirVehiculo(new Turismo("1111TTT","Volvo XC60",0));
        Empresa.añadirVehiculo(new Turismo("2222TTT","Audi A4",0));
        Empresa.añadirVehiculo(new Furgoneta("2222FFF","Citröen C16",0));
        
        Empresa.listarFlota();
        
        Vehiculo v;
        
//        v=Empresa.obtenerVehiculo("2222FFF");
//        v.alquilar();
//        v.devolver();
//        System.out.println("---------------------------------");
        v=Empresa.obtenerVehiculo("1111TTT");
        //v.alquilar();
        //v.devolver();
        
        
        
        
    }
    
}
