/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio02;

/**
 *
 * @author jacuela
 */
public class Ejercicio02_pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        UsuNormal zipi=new UsuNormal("zipi","zipi","zipio@kk.com");
        BD_Usuarios.añadirUsuario(zipi);
       
        UsuNormal zape=new UsuNormal("zape","zape","zape@kk.com");
        BD_Usuarios.añadirUsuario(zape);
        
        UsuAdmin root=new UsuAdmin("root","root","admin@admin.com");
        BD_Usuarios.añadirUsuario(root);
     
        zipi.listarUsuarios(BD_Usuarios.obtenerBD());
        root.listarUsuarios(BD_Usuarios.obtenerBD());
       
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       
        //usuario3.cambiarPassword("homer2");
        root.cambiarPassword("zipi");
        root.listarUsuarios(BD_Usuarios.obtenerBD());
        
        
        
    }
    
}
