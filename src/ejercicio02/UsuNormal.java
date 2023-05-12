/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author jacuela
 */
public class UsuNormal {
  
    private String nombre;
    private String password;
    private String email;
    //protected TipoUsuario tipo;
    
    
    public UsuNormal(String nombre, String password, String email){
        this.nombre=nombre;
        this.password=password;
        this.email=email;
        //this.tipo=TipoUsuario.NORMAL;
        
    }
    
    //getter and setter
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    
    //***************** fin getter and setter
    
    public void cambiarPassword(){
        Scanner scn = new Scanner(System.in);
        System.out.println("");
        System.out.println("Cambiando password de <"+this.nombre+">");
        System.out.print("Nuevo password:");
        String nuevopassword=scn.nextLine();
        this.password=nuevopassword;
        System.out.println("El password ha sido cambiado");
        
    }
    
    public void listarUsuarios(ArrayList<UsuNormal> bd){
        
        System.out.println("");System.out.println("");
        
        System.out.println("             LISTA DE USUARIOS");
        System.out.println("===============================================");
        for (int i = 0; i < bd.size(); i++) {
        
            //Compruebo el tipo de usuario que es
            //Si es un administrador, muestro una A al lado del nombre
            //Como estoy en la version de UsuNormal, muestro oculto el password
            if (bd.get(i) instanceof UsuAdmin){
                System.out.printf("A  %10s ********** %s\n",bd.get(i).getNombre(),bd.get(i).getEmail());
            }
            else{
                System.out.printf("   %10s ********** %s\n",bd.get(i).getNombre(),bd.get(i).getEmail());
            }
            
            
        }
        
    }
    
    @Override
    public String toString(){
        
        return String.format("%s     %s     %s",this.nombre,this.password,this.email);
        
    }
    
    
    

}
