/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06;

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
        
        BD_Empresa.añadirVehiculo(new Turismo("1111TTT","Volvo XC60",0));
        BD_Empresa.añadirVehiculo(new Turismo("2222TTT","Audi A4",0));
        BD_Empresa.añadirVehiculo(new Furgoneta("2222FFF","Citröen C16",0));
        
        BD_Empresa.listarFlota();
        
        Vehiculo v;
        
//        v=BD_Empresa.obtenerVehiculo("2222FFF");
//        v.alquilar();
//        v.devolver();
//        System.out.println("---------------------------------");
        v=BD_Empresa.obtenerVehiculo("1111TTT");
        //v.alquilar();
        //v.devolver();
        
        
        
        
    }
    
}
