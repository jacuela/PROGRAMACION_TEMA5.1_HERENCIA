/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jacuela
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalDate fecha;
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Cliente pedro=new Cliente("4444A","Pedro","Cano Cano");
        Cliente alicia=new Cliente("2222A","Alicia","Morillas Lopez");
        
        
        
        Banco miBanco=new Banco("FloriBANK");
        
        miBanco.nuevoCliente(alicia);
        miBanco.nuevoCliente(pedro);
        
        
        //Podríamos definir las diferentes variables de las cuentas al tratarse de un 
        //programa pequeño, y tendríamos "a mano" todas las cuentas.Pero en un programa
        //grande o con un menu, esto no se suele hacer. Cuando necesitamos tener acceso
        //a alguna cuenta, la buscamos en la base de datos. Así vamos a proceder.
       
        
        //Directamente creamos los objetos y los añadimos a la vase de datos.
     
        fecha=LocalDate.parse("01/01/2021", dtf);
        miBanco.insertar(new CuentaCorriente(alicia,1000,fecha));
     
        fecha=LocalDate.parse("01/01/2021", dtf);
        miBanco.insertar(new Deposito(alicia,10000,fecha));
     
        
        fecha=LocalDate.parse("01/01/2021", dtf);
        miBanco.insertar(new CuentaCorriente(pedro,1,fecha));
     
        
       
        miBanco.listarEstadoCuentas();
        
        
        
        CuentaBancaria cuenta1001=miBanco.buscar(1001);
        cuenta1001.ingreso(500);
        cuenta1001.transferencia(miBanco.buscar(1003),1000);
        cuenta1001.reintegro(500);
        cuenta1001.reintegro(1);
        
        
        System.out.println("");
        
        //Buscar la cuenta 1004 y transferir 100€ a la cuenta 1001 
         CuentaBancaria cuenta1002=miBanco.buscar(1002);
         cuenta1002.reintegro(100);
         cuenta1002.ingreso(100);
         
        
       
        miBanco.listarEstadoCuentas();
        
        
        
    }
    
}
