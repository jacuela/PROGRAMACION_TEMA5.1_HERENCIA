/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio05;

import ejercicio02bis.UsuAdmin;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class InicioMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        
        //=========== DATOS PARA LA INICIALIZACION ===========================
        Cliente pedro=new Cliente("1111A","Pedro","Cano Cano");
        Cliente alicia=new Cliente("2222A","Alicia","Morillas Lopez");
        
        
        
         Banco floriBANK=new Banco("FloriBANK");
        
         System.out.println(floriBANK);
        
        
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
        
        
        
        
        
    }
    
}
