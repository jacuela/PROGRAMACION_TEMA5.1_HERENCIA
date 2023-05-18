/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import ejercicio06.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author juan.antonio
 */
public class Empresa {
    
    private static ArrayList<Vehiculo> listaVehiculos; //=new ArrayList();
    private static ArrayList<Alquiler> listaAlquileres; //=new ArrayList();
    
    
    
    public static void añadirVehiculo(Vehiculo v){
        //====== MOFICACION PARA BBDD ========
        //Añadimos el vehículo a la bbdd
        BD_EmpresaSQL.añadirVehiculo(v);
        
        //listaVehiculos.add(v);  //no nos interesa ya tener el arraylist consistente
        
    }
   
    public static void añadirAlquiler(Alquiler a){
        //====== MOFICACION PARA BBDD ========
        //Poner el vehiculo en la bbdd a alquilado
        BD_EmpresaSQL.setCampoAlquilado(a.getVehiculo().getMatricula(), true);
        
        //Crear un nuevo alquiler
        BD_EmpresaSQL.añadirAlquiler(a);
        
        //listaAlquileres.add(a);
    }
   
    
     public static void finalizarAlquiler(Vehiculo vehiculo, LocalDate fecha_devolucionLD, int km) {
        
        //Obtengo el ID del alquiler sin terminar. 
        int id_alquiler=BD_EmpresaSQL.obtenerIDAlquilerSinTerminar(vehiculo);
        Alquiler alquiler;
        
        //Vamos a obtener el alquiler para poder calcular el importe
        //Le paso el vehiculo porque el objeto alquiler lleva como atributo
        //un vehichulo y a la hora de construir el objeto, lo voy a rellenar
        //Ademas, lo necesito para hacer el calculo del importe
        
        
        alquiler=BD_EmpresaSQL.obtenerAlquiler(id_alquiler,vehiculo);
        alquiler.setFecha_fin(fecha_devolucionLD);
        alquiler.setKm_fin(km);
        alquiler.calcularImporte();
          
       
        
        //PASAMOS LOS DATOS A LA BBDD
        //1º - Actualizo los datos del alquiler en la bbdd indicando fecha devolucion, km e importe
        BD_EmpresaSQL.finalizarAlquiler(id_alquiler,fecha_devolucionLD,km,alquiler.getImporte());
        
        
        //2º - Actualizar los datos del vehiculo en la bbdd
        //Poner el vehiculo en la bbdd a NO ALQUILADO
        BD_EmpresaSQL.setCampoAlquilado(vehiculo.getMatricula(), false);
        
        //Actualizar los km
        BD_EmpresaSQL.actualizarKmVehiculo(vehiculo.getMatricula(),km);
        
        
        //Muestro los datos del alquiler. Lo hago ahora que tengo todos los datos correctos
        //Necesito volver a pedir los datos a la bbdd
        System.out.println("mostrando los datos del alquiler "+id_alquiler);
        alquiler=BD_EmpresaSQL.obtenerAlquiler(id_alquiler,vehiculo);
        alquiler.imprimir();
        
    }
    
    
    
    
    
    
    public static void listarFlota(){
        
        //====== MOFICACION PARA BBDD ========
        listaVehiculos = BD_EmpresaSQL.getListaVehiculosSQL();
        
        
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
        //====== MOFICACION PARA BBDD ========
        //Ya no miramos el array list. Hacemos la consulta a la bbdd
        Vehiculo v=BD_EmpresaSQL.obtenerVehiculo(matricula);
        return v; //devuelve el vehiculo o null
    }
    
    
    
    
//    public static Alquiler obtenerUltimoAlquiler(String matricula){
//      
//        Alquiler ultimoAlquiler=null;
//        
//        for (Alquiler a : listaAlquileres) {
//            if (a.getVehiculo().getMatricula().equals(matricula))
//                ultimoAlquiler=a;
//        }
//        return ultimoAlquiler;
//       
//        
//        
//    }
    
    public static void imprimirHistoricoAlquileresJSON(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        
        //aqui pido a la bbdd el listado de alquileres en formato JSON
        JSONArray jsonListaAlquileres = BD_EmpresaSQL.obtenerListaAlquileresJSON();
        JSONObject json;
        System.out.println("");
        System.out.println("");
        System.out.println("===========  HISTORICO DEL ALQUILERES  ===========");
        for (int i = 0; i < jsonListaAlquileres.length(); i++) {
                json = jsonListaAlquileres.getJSONObject(i);
               
                if (json.getDouble("importe")!=0){
                     System.out.printf("%2d - %6s - %s - %.2f\n",
                        json.getInt("id"),
                        json.getString("matricula"),
                        json.getString("fecha_inicio"),
                        json.getDouble("importe")
                        );
                    
                }
                else{
                     System.out.printf("%2d - %6s - %s - SIN FINALIZAR\n",
                        json.getInt("id"),
                        json.getString("matricula"),
                        json.getString("fecha_inicio")
                        );
                    
                }
         
        }        
        System.out.println("==================================================");
        
        
       
        
    }

    
    public static void imprimirHistoricoAlquileres(){
        
        //====== MOFICACION PARA BBDD ========
        //aqui pido a la bbdd el listado de alquileres
        //ArrayList<Alquiler> = BD_EmpresaSQL.obtenerListaAlquileres();
        
        
        System.out.println("===========  HISTORICO DEL ALQUILERES  ===========");
        for (Alquiler alquiler : listaAlquileres) {
            System.out.println(alquiler);
        }
        System.out.println("==================================================");
    }
   
    
    
    
}
