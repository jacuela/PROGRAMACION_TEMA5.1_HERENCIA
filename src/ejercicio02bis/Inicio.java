/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio02bis;

import java.util.Scanner;

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
        Scanner teclado = new Scanner(System.in);
        
        int intentosLogin=2;
        //UsuNormal usuarioActual;
        
        
        //================  INICIALIZACIÓN ================================ 
        BD_Usuarios.añadirUsuario("zipi", "zipi", "zipi@kk.com", false);
        BD_Usuarios.añadirUsuario("zape", "zape", "zape@kk.com", false);
        BD_Usuarios.añadirUsuario("root", "root", "zipi@kk.com", true);
        //=================================================================
        
        do{
            System.out.println("");
            System.out.println("Login");
            System.out.println("*****************");
            System.out.print("Usuario: ");
            String usuario = teclado.nextLine();
            System.out.print("Contraseña: ");
            String password = teclado.nextLine();
            
            //Ahora compruebo si son correctas estas credenciales
            
            if (BD_Usuarios.verificarLogin(usuario, password)){
                //Obtengo el objeto usuario
                UsuNormal usuarioActual = BD_Usuarios.obtenerUsuario(usuario);
                intentosLogin=2;
                menu(usuarioActual);
            }else{
                intentosLogin--;
            }
            
        }while(intentosLogin>0);
        
        if (intentosLogin==0){
            System.out.println("");
            System.out.println("Login fallido. Bye bye julai.");
        }
        
    }
    
    
    public static void menu(UsuNormal usuario){
        //Este es el menu de usuario. Dependiendo del tipo
        //de usuario, mostrara mas o menos opciones
        Scanner teclado= new Scanner(System.in);
        int opcion;
        boolean salir=false;
        
        do{
            System.out.println("****************************");
            if (usuario instanceof UsuAdmin){
                System.out.println("Administrador: << "+usuario.getNombre()+" >>");
            }else{
                System.out.println("Usuario: << "+usuario.getNombre()+" >>");
            }
            System.out.println("****************************");
            System.out.println("1. Salir del sistema");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Cambiar password");
            //Solo si soy admin, muestro la opcion4
            if (usuario instanceof UsuAdmin){
                System.out.println("4. Cambiar password de otro Usuario");
            }
            System.out.print(">Elige una opcion:");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch (opcion){
                case 1: 
                    salir=true;
                    break;
                case 2:
                    usuario.listarUsuarios();
                    break;
                case 3:
                    usuario.cambiarPassword();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Dime ID del usuario a cambiar password:");
                    System.out.print(">");
                    int id = Integer.parseInt(teclado.nextLine());
                    
                    ((UsuAdmin)usuario).cambiarPassword(id);
                    break;
                default:
                    System.out.println("Opion incorrecta.");
            }
        }while (!salir);
        //}while (salir==false);
    }
    
    
    
    
    
}
