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
public class BD_Usuarios {
    
    private static ArrayList<UsuNormal> bd=new ArrayList();
    
    
    public static void añadirUsuario(UsuNormal usuario){
        bd.add(usuario);
        
    }
    
    public static ArrayList<UsuNormal> obtenerBD(){
        return bd;
        
    }
    
    public static UsuNormal obtenerUsuario(String usuario){
        for (int i = 0; i < bd.size(); i++) {
            
           if( bd.get(i).getNombre().equals(usuario) ){
              return bd.get(i);
           }
        }
        
        //Si llegamos aquí, es que hemos recorrido el bucle
        //y no hemos encontrado al usuario. Devolveremos <null>
        
        return null;
    }
    
    
    /**
     * Método que verifica si el usuario y contraseña son correctos. 
     */
    
    public static boolean verificarLogin(String usuario, String password){
        
        for (int i = 0; i < bd.size(); i++) {
            if( bd.get(i).getNombre().equals(usuario) && bd.get(i).getPassword().equals(password)  ){
                
                //Usuario encontrado. Contraseña correcta.
                return true;
                
            }
            
        }
        //Si llego aquí es porqu no he encontrado el usuario
        return false;
    }
    
    
    
}
