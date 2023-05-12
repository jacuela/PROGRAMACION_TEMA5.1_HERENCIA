/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio02;

import java.util.Scanner;
import java.lang.System;



/**
 *
 * @author jacuela
 */
public class Ejercicio02_menu {

    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        
        String simbolo2="\u263A";
        String simbolo1="\u2639";
        
        int intentosLogin=2;
        UsuNormal usuarioActual;
        
        //******** ME CREO 3 USUARIOS ****************************************
        BD_Usuarios.añadirUsuario(new UsuNormal("zipi","1234","zipi@kk.com"));
        BD_Usuarios.añadirUsuario(new UsuNormal("zape","1234","zape@kk.com"));
        BD_Usuarios.añadirUsuario(new UsuAdmin("root","root","admin@admin.com"));
        //********************************************************************
        
        do{
            System.out.println("\n\nLogin");
            if (intentosLogin==2) System.out.println("***********  "+simbolo2);
            if (intentosLogin==1) System.out.println("***********  "+simbolo1);
            
            System.out.print("usuario:");
            String usuario=scn.nextLine();
            System.out.print("contraseña:");
            String password=scn.nextLine();

            //Ahora comprobaremos que existe el usuario y que la contraseña
            //es la correcta. 
            if (BD_Usuarios.verificarLogin(usuario, password)){
                usuarioActual=BD_Usuarios.obtenerUsuario(usuario);
                intentosLogin=2;
                menu(usuarioActual);
            }
            else{
                intentosLogin--;
            }
     
        } while(intentosLogin > 0);
        
        if (intentosLogin==0)
            System.out.println("Login fallido. Bye bye.");
        
        
    }
    
    
    
    public static void menu(UsuNormal usuario){
        Scanner scn = new Scanner(System.in);
        int opcion;
        boolean salir=false;
        
        
        //Muestro el menu en un bucle while 
        while(!salir){
           
           System.out.println("\n\n");
           System.out.println("***************************");
           if (usuario instanceof UsuNormal) System.out.println("Usuario: << "+usuario.getNombre()+" >>");
           if (usuario instanceof UsuAdmin) System.out.println("Administrador: << "+usuario.getNombre()+" >>");
           System.out.println("***************************");
           
           
           System.out.println("1. Salir del sistema");
           System.out.println("2. Listar Usuarios");
           System.out.println("3. Cambiar Password");
           if (usuario instanceof UsuAdmin) System.out.println("4. Cambiar Password Usuario");
           
           System.out.print("Elige una opcion >");
           
           opcion = Integer.parseInt(scn.nextLine());
            
           switch(opcion){
               case 1:
                   salir=true;
                   break;
              
               case 2:
                   usuario.listarUsuarios(BD_Usuarios.obtenerBD());
                   pulseIntroParaContinuar();
                   break;
                   
               case 3:
                   usuario.cambiarPassword();
                   pulseIntroParaContinuar();
                   break;
              
               case 4:
                   //if (usuario.tipo==TipoUsuario.ADMIN){
                   if (usuario instanceof UsuAdmin){
                        System.out.println("");
                        System.out.print("Usuario a resetear password: ");
                        String resetusuario=scn.nextLine();
                        //Aquí podría comprobar el casting con un instanceof
                        ((UsuAdmin)usuario).cambiarPassword(resetusuario);
                        pulseIntroParaContinuar();
                   }
                   else
                       System.out.println("Opcion no disponible");
                   break;
              
              default:
                   System.out.println("Solo números entre 1 y 4");
           }
            
         } //fin menu
        
        
    }
    
    
    private static void pulseIntroParaContinuar(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\033[34m        Pulse INTRO para continuar....\033[30m");
        String tecla=scn.nextLine();
                   
        
    }
    
    
}
