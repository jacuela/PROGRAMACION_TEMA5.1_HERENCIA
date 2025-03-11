/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio02bis;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        BD_Usuarios.añadirUsuario("zipi", "zipi", "zipi@kk.com", false);
        BD_Usuarios.añadirUsuario("zape", "zape", "zape@kk.com", false);
        BD_Usuarios.añadirUsuario("root", "root", "zipi@kk.com", true);
        
        //Imagino que este método es llamado un un administrado
        BD_Usuarios.listarUsuarios(true);
        
        
        //Imagino que este método es llamado por un subnormal
        BD_Usuarios.listarUsuarios(false);
        
        
        
        
        
        
    }
    
}
