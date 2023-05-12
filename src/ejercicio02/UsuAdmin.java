/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio02;

import java.util.ArrayList;

/**
 *
 * @author jacuela
 */
public class UsuAdmin extends UsuNormal {
    
    public UsuAdmin(String nombre, String password, String email) {
        super(nombre, password, email);
        
       
    }
    
    @Override
    public void listarUsuarios(ArrayList<UsuNormal> bd){
        
        System.out.println("");System.out.println("");
        System.out.println("             LISTA DE USUARIOS");
        System.out.println("===============================================");
        for (int i = 0; i < bd.size(); i++) {
        
            //Compruebo el tipo de usuario que es
            //Si es un administrador, muestro una A al lado del nombre
            //Como estoy en la version de UsuAdmin, muestro en claro el password
            if (bd.get(i) instanceof UsuAdmin){
                System.out.printf("A  %10s %10s %s\n",bd.get(i).getNombre(),bd.get(i).getPassword(),bd.get(i).getEmail());
            }
            else{
                System.out.printf("   %10s %10s %s\n",bd.get(i).getNombre(),bd.get(i).getPassword(),bd.get(i).getEmail());
            }
        }
        
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public void cambiarPassword(String usuario){
        
        UsuNormal usuNormal=BD_Usuarios.obtenerUsuario(usuario);
        
        if (usuNormal != null){
            usuNormal.cambiarPassword();
        }
        else{
            System.out.println("\n\033[31m WARNING:El usuario "+usuario+" no existe.");
        }
        
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    
    
    
}
