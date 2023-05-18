/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import ejercicio06.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Ejercicio06_menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner teclado = new Scanner(System.in);
        int opcion;
        Vehiculo v;
        LocalDate fecha_alquilerLD, fecha_devolucionLD;
        int km_devolucion;
        String matricula;
        boolean salir=false;
        
        
//        //***************************************************************
//        //Añadir algunos vehiculos en codigo
//        Empresa.añadirVehiculo(new Turismo("1111TTT","Volvo XC60",0));
//        Empresa.añadirVehiculo(new Turismo("2222TTT","Audi A4",0));
//        Empresa.añadirVehiculo(new Furgoneta("2222FFF","Citröen C16",0));
//        //*****************************************************************
        
        
        System.out.print("Conectando con base de datos ALQUILERVEHICULOS......");
        if (BD_EmpresaSQL.conectar()==null) 
            System.out.println("\033[31mERROR");
            
        else{
            System.out.println("\033[32mOK");


            

        //Muestro el menu en un bucle while 
        while(!salir){
           
           System.out.println("\n\n");
//           System.out.println("***************************");
//           System.out.println("   ALQUILER DE VEHICULOS");
//           System.out.println("***************************");
           Empresa.listarFlota();

           System.out.println("1. Añadir vehiculo");
           System.out.println("2. Historico alquileres");
           System.out.println("3. Alquilar");
           System.out.println("4. Devolvr");
           System.out.println("5. Salir");
           
           System.out.print("Elige una opcion >");
           opcion = Integer.parseInt(teclado.nextLine());
            
           switch(opcion){
               case 1:
                   System.out.println("Añadiendo un vehiculo....");
                   System.out.print("  ¿Furgoneta o turismo?  [F | T]: ");
                   String tipo=teclado.nextLine();
                   if (tipo.equals("F") || tipo.equals("T") ){
                       System.out.print("  Matricula: ");
                       matricula=teclado.nextLine();
                       System.out.print("  Marca y modelo: ");
                       String marca_modelo=teclado.nextLine();
                       System.out.print("  Kilometros: ");
                       int km=Integer.parseInt(teclado.nextLine());
                       if (tipo.equals("F"))
                         Empresa.añadirVehiculo(new Furgoneta(matricula,marca_modelo,km));
                       if (tipo.equals("T")) 
                         Empresa.añadirVehiculo(new Turismo(matricula,marca_modelo,km));
                   }
                   else
                       System.out.println("Tipo erroneo. Indica F o T (y no numeros como Joaquin)");
                   pulseIntroParaContinuar();
                   break;
              
               case 2:
                   Empresa.imprimirHistoricoAlquileresJSON();
                   //Empresa.imprimirHistoricoAlquileres();
                   
                   break;
                   
               case 3:
                   System.out.print("Alquilando vehiculo.....");
                   boolean fechaCorrecta=false;
                   do {
                        System.out.print("Matricula??: ");
                        matricula=teclado.nextLine();
                        v=Empresa.obtenerVehiculo(matricula); 
                        if (v==null) System.out.println("\033[31mERROR: matricula no encontrada\033[30m");
                   }
                   while (v==null);      
                        
                        
                   if (v instanceof Turismo){
                       System.out.println("TURISMO ENCONTRADO "+matricula);
                   }
                   if (v instanceof Furgoneta){
                       System.out.println("FURGONETA ENCONTRADO "+matricula); 
                   }  
                   //Pido siempre la fecha de alquiler para que conste
                   
                   do{
                     try{
                        System.out.print("   >Fecha de alquiler[dd/mm/aaaa] (INTRO PARA HOY): ");
                        String fecha_alquiler=teclado.nextLine();

                        if (fecha_alquiler.equals("")){
                             fecha_alquilerLD=LocalDate.now();
                             System.out.println(fecha_alquilerLD.format(dtf));
                        }else{
                             fecha_alquilerLD=LocalDate.parse(fecha_alquiler,dtf);
                        }
                        fechaCorrecta=true;
                        System.out.println("  >Kilometros actuales: "+v.km);
                      
                        v.alquilar(fecha_alquilerLD,v.km);
                        
                        pulseIntroParaContinuar();
                     }
                     catch(Exception e){
                        System.out.println("\033[31mERROR: fecha incorrecta\033[30m"); 
                     }
                   }while(fechaCorrecta==false);
                     
                    break;
              
               case 4:
                   System.out.print("Devolviendo vehiculo.....");
                   boolean fechaCorrecta2=false;
                   do {
                        System.out.print("Matricula??: ");
                        matricula=teclado.nextLine();
                        v=Empresa.obtenerVehiculo(matricula);
                        if (v==null) System.out.println("\033[31mERROR: matricula no encontrada\033[30m");
                   }
                   while (v==null);      
                   
                   if (v instanceof Turismo){
                       System.out.println("TURISMO ENCONTRADO "+matricula);
                   }
                   if (v instanceof Furgoneta){
                       System.out.println("FURGONETA ENCONTRADO "+matricula); 
                   }  
                   //Pido siempre la fecha de devolucion para que conste en el alquiler
                   do{
                     try{
                        System.out.print("   >Fecha de devolucion[dd/mm/aaaa] (INTRO PARA HOY): ");
                        String fecha_devolucion=teclado.nextLine();

                        if (fecha_devolucion.equals("")){
                             fecha_devolucionLD=LocalDate.now();
                             System.out.println(fecha_devolucionLD.format(dtf));
                        }else{
                             fecha_devolucionLD=LocalDate.parse(fecha_devolucion,dtf);
                        }
                        fechaCorrecta2=true;
                        
                        System.out.print("   >KM actuales del vehiculo: ");
                        km_devolucion=Integer.parseInt(teclado.nextLine());
                       
                        v.devolver(fecha_devolucionLD,km_devolucion);
                        
                        pulseIntroParaContinuar();
                     }
                     catch(Exception e){
                        System.out.println(e); 
                     }
                   }while(fechaCorrecta2==false);
                   
                   break;
              
               case 5:
                   salir=true;
                   break;
              default:
                   System.out.println("Solo números entre 1 y 5");
           }
            
         } //fin while menu
        
        }//fin conexion
        
    }
    
    private static void pulseIntroParaContinuar(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\033[34m        Pulse INTRO para continuar....\033[30m");
        String tecla=scn.nextLine();
                   
        
    }
    
    
    
    
}
