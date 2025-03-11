/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02bis;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class BD_Usuarios {
    
    private static ArrayList<UsuNormal> bd=new ArrayList();
    
    
    public static void añadirUsuario(String nombre,
                                     String password,
                                     String email,
                                     boolean esAdmin){
        
        if (esAdmin){
            bd.add(new UsuAdmin(nombre,password,email));
        }
        else{
            bd.add(new UsuNormal(nombre,password,email));
        }
        
    }
    
    public static UsuNormal obtenerUsuario(int id){
        
        for (UsuNormal usuario : bd) {
            if (usuario.getId()==id){
                //Lo he encontrado
                return usuario;
            }
        }
        
        return null;
    }
    
    public static boolean verificarLogin(String nombre,
                                         String password){
        
        for (UsuNormal usuario : bd) {
            if (usuario.getNombre().equals(nombre)
                && usuario.getPassword().equals(password)){
                
                //Usuario encontrado y coincide password.
                return true;
            }
        }
        
        return false;
    }
    
    
    public static void listarUsuarios(boolean esAdmin){
        
        //Este método lista los usuarios. Si el método
        //es llamado por un usuario administrado, listaremos
        //todos los datos. Si es llamdo por un usuario normal,
        //ocultaremos el password
        
        System.out.println("");
        System.out.println("           LISTA DE USUARIOS");
        System.out.println("=========================================");
        if (esAdmin){
            for (UsuNormal usuario : bd) {
                System.out.println(usuario);
            }
            
            
        }else{
            for (UsuNormal usuario : bd) {
                
                if (usuario instanceof UsuAdmin){
                    System.out.printf("A%2d %10s ********** %s\n",usuario.getId(),
                                                            usuario.getNombre(),
                                                            usuario.getEmail());
                }
                else{
                    System.out.printf(" %2d %10s ********** %s\n",usuario.getId(),
                                                            usuario.getNombre(),
                                                            usuario.getEmail());
                }
                
                
                
            }
            
        }
        
        
        
    }
    
    
    
    
    
}
