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
 * @author juan antonio cuello alarcón
 */
public class UsuNormal {
  
    protected String nombre;
    protected String password;
    protected String email;
    
    
    public UsuNormal(String nombre, String password, String email){
        this.nombre=nombre;
        this.password=password;
        this.email=email;
        
    }
    
    
    @Override
    public String toString(){
        return String.format("%10s %10s %s",this.nombre,this.password,this.email);
    }
    
    
    public void cambiarPassword(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("Cambiando password de <"+this.nombre+">");
        System.out.print("Nuevo password:");
        String nuevopassword=teclado.nextLine();
        this.password=nuevopassword;
        System.out.println("El password ha sido cambiado");
        
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
    

}
