/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.time.LocalDate;

/**
 *
 * @author jacuela
 */
public class CuentaCorriente extends CuentaBancaria {
    private double maxDescubierto;

    public CuentaCorriente(Persona titular, double saldo, LocalDate fecha){
        super(titular,saldo,fecha);
        maxDescubierto=-1000;
    }
    
    public void setMaxDescubierto(double maximo){
        maxDescubierto=maximo;
    }
    
    
    @Override
    public boolean reintegro(double dinero) {
        
        //Primero compruebo si se puede hacer el reintregro
        //Se puede hacer si no supero el descubiero
        if ( (this.getSaldo()-dinero)<maxDescubierto ){
            this.mostrarERROR();
            System.out.println("Saldo insuficiente. Superado el descubierto de "+maxDescubierto+"€");
            return false;
        }
        else{
            this.setSaldo(this.getSaldo()-dinero);
            this.mostrarOK();
            return true;
        }
    
    }
    
    
    @Override
    public void transferencia(CuentaBancaria cb, double importe){
        if ( (this.getSaldo()-importe)<maxDescubierto ){
            this.mostrarERROR();
            System.out.println("Saldo insuficiente. Superado el descubierto de "+maxDescubierto+"€");
        }
        else{
            this.reintegro(importe);
            cb.ingreso(importe);
            this.mostrarOK();
       
        }
        
    }        
   
    @Override
    public double calcularIntereses() {
        return  0;
    }
            
            
            
            
            
}
