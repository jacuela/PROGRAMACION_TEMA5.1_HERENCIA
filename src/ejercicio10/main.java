/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

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
        CuentaBancaria cuenta1,cuenta2,cuenta;
        LocalDate fecha;
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Persona pedro=new Persona("44444444A","Pedro","Cano Cano","pedro@gmail.com");
        Persona alicia=new Persona("22222222A","Alicia","Morillas Lopez","pedro@gmail.com");
        
        BD_BancoImpl mibd=new BD_BancoImpl();
        
        
        
        //Podríamos definir las diferentes variables de las cuentas al tratarse de un 
        //programa pequeño, y tendríamos "a mano" todas las cuentas.Pero en un programa
        //grande o con un menu, esto no se suele hacer. Cuando necesitamos tener acceso
        //a alguna cuenta, la buscamos en la base de datos. Así vamos a proceder.
       
        
        //Directamente creamos los objetos y los añadimos a la vase de datos.
     
        fecha=LocalDate.parse("01/01/2021", dtf);
        mibd.insertar(new CuentaAhorro(alicia,10000,fecha));
     
        fecha=LocalDate.parse("01/01/2020", dtf);
        mibd.insertar(new Deposito(pedro,50000,fecha));
       
        mibd.insertar(new CuentaCorriente(pedro,1000,LocalDate.now()));
     
        mibd.insertar(new CuentaCorriente(alicia,5000,LocalDate.now()));
     
        
        System.out.println("****** ESTADO INICIAL DE LAS CUENTAS ******");
        mibd.listar();
        
        
        
        //Buscar la cuenta 1003 y hacer un reintegro de 1500€ 
        // y
        //Hacer otro reintegro de 1000€ en la misma cuenta
        cuenta=mibd.buscar(1003);
        if (cuenta!=null){
            cuenta.reintegro(1500);
            cuenta.reintegro(1000);
        }
        
        //Buscar la cuenta 1004 y transferir 100€ a la cuenta 1001 
         cuenta1=mibd.buscar(1004);
         cuenta2=mibd.buscar(1001);
         
        if (cuenta1!=null && cuenta2!=null){
            cuenta1.transferencia(cuenta2, 100);
        }
      
        //Buscar la cuenta de ahorro 1001 y ingresar 5000€
        // y
        //Imprimir la cuenta (mostrará unos intereses de 212€ correspondientes a 4 meses)
        cuenta=mibd.buscar(1001);
        if (cuenta!=null){
            cuenta.ingreso(5000);
            System.out.println(cuenta);
        }
        
        //Buscar el deposito 1002 y ingresar 1000€ (error, no puedo ingresar en depósito)
        // y
        //Imprimir el deposito (mostrará unos intereses de 2500€ correspondientes a 1 año) 
        cuenta=mibd.buscar(1002);
        if (cuenta!=null){
            cuenta.ingreso(1000);
            System.out.println(cuenta);
        }
        
        System.out.println("****** ESTADO FINAL DE LAS CUENTAS ******");
        mibd.listar();
        
        
        
    }
    
}
