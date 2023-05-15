/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06;

import java.util.ArrayList;

/**
 *
 * @author juan.antonio
 */
public class BD_Empresa {
    
    private static ArrayList<Vehiculo> listaVehiculos=new ArrayList();
    private static ArrayList<Alquiler> listaAlquileres=new ArrayList();
    
    public static void añadirVehiculo(Vehiculo v){
        listaVehiculos.add(v);
    }
   
    public static void añadirAlquiler(Alquiler a){
        listaAlquileres.add(a);
    }
   
    public static void listarFlota(){
        
        System.out.println("=========================================");
        System.out.println("\033[34m      LISTADO DE TURISMOS    \033[30m");
        for (Vehiculo v : listaVehiculos) {
            if (v instanceof Turismo){
                if (v.isAlquilado()){
                    System.out.println("\033[35mA   "+v+"\033[30m");
                }
                else{
                    System.out.println("    "+v);
                }        
            }
        }
        System.out.println("");
        System.out.println("\033[34m      LISTADO DE FURGONETAS    \033[30m");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo v=listaVehiculos.get(i);
            if (v instanceof Furgoneta){
                if (v.isAlquilado()){
                    System.out.println("\033[35mA   "+v+"\033[30m");
                }
                else{
                    System.out.println("    "+v);
                }   
            }
        }
        System.out.println("=========================================");
        
    }
    
    public static Vehiculo obtenerVehiculo(String matricula){
        for (Vehiculo v : listaVehiculos) {
            if (v.getMatricula().equals(matricula))
                return v;
        }
        return null;
    }
    
    public static Alquiler obtenerUltimoAlquiler(String matricula){
        Alquiler ultimoAlquiler=null;
        
        for (Alquiler a : listaAlquileres) {
            if (a.getVehiculo().getMatricula().equals(matricula))
                ultimoAlquiler=a;
        }
        return ultimoAlquiler;
       
        //Esta forma es más eficiente. Recorremos el array
        //a la inversa y cuando encontramos el Alquiler, salimos.
//        for (int i = listaAlquileres.size()-1; i >=0; i--) {
//            ultimoAlquiler=listaAlquileres.get(i);
//            if (ultimoAlquiler.getVehiculo().getMatricula().equals(matricula)){
//                return ultimoAlquiler;
//            }
//        }
//        return null;
        
    }
    
    public static void imprimirHistoricoAlquileres(){
        System.out.println("===========  HISTORICO DEL ALQUILERES  ===========");
        for (Alquiler alquiler : listaAlquileres) {
            System.out.println(alquiler);
        }
        System.out.println("==================================================");
    }
    
    
    
}
