/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

import java.util.ArrayList;

/**
 *
 * @author jacuela
 */
public class Banco {

    private String nombre;
    private ArrayList<CuentaBancaria> listaCuentasBancarias;
    private ArrayList<Cliente> listaClientes;
    
    
    private static double INTERES_DEPOSITO=5;
    private static double INTERES_CUENTACORRIENTE=0;
    
    
    public Banco(String nombre){
        this.nombre = nombre;
        
        listaCuentasBancarias=new ArrayList();
        listaClientes = new ArrayList();
    }
    
    
    public void nuevoCliente(String dni, String nombre, String apellidos){
        listaClientes.add(new Cliente(dni,nombre,apellidos));
        
    }
    
    public void nuevoCliente(Cliente c){
        listaClientes.add(c);
        
    }
    
    
    public void insertar(CuentaBancaria c) {
        listaCuentasBancarias.add(c);
    }

    public CuentaBancaria buscar(int numero) {
        
        for (CuentaBancaria c: listaCuentasBancarias){
                if (c.getNumero()==numero)
                    return c;
        }
        return null;        
    }

    public void listarEstadoCuentas() {
        
        System.out.println("\033[34m");
        System.out.println("\033[34m-----------------------------------------------------");
        System.out.println("\033[34m                ESTADO DE LAS CUENTAS");
        System.out.println("\033[34m-----------------------------------------------------");
        System.out.println("\033[34m      TIPO    NUM    TIT       SALDO      INTERESES");
        System.out.println("");
        
        for (CuentaBancaria c : listaCuentasBancarias) {
            System.out.print(c);
        }
        System.out.println("\033[34m-----------------------------------------------------");
        System.out.println("");
        
    
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        
        sb.append("==================================\n");
        sb.append("        "+this.nombre+"\n");
        sb.append("Interes C.Corriente:"+Banco.INTERES_CUENTACORRIENTE);
        sb.append("Interes Deposito:"+Banco.INTERES_DEPOSITO);
        sb.append("==================================\n");
        return sb.toString();
    }
    

    //Getter and Setter

    public static double getINTERES_DEPOSITO() {
        return INTERES_DEPOSITO;
    }

    public static void setINTERES_DEPOSITO(double INTERES_DEPOSITO) {
        Banco.INTERES_DEPOSITO = INTERES_DEPOSITO;
    }

    public static double getINTERES_CUENTACORRIENTE() {
        return INTERES_CUENTACORRIENTE;
    }

    public static void setINTERES_CUENTACORRIENTE(double INTERES_CUENTAAHORRO) {
        Banco.INTERES_CUENTACORRIENTE = INTERES_CUENTAAHORRO;
    }

    

   



    
}
