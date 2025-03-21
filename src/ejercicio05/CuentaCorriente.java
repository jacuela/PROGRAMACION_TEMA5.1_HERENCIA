/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jacuela
 */
public class CuentaCorriente extends CuentaBancaria {
    
    public CuentaCorriente(Cliente titular, double saldo, LocalDate fecha){
        super(titular,saldo,fecha);
       
        this.TAE = Banco.getINTERES_CUENTACORRIENTE();
        
    }

    
    @Override
    public boolean ingreso (double importe){
            this.saldo = this.saldo + importe;
            return true;
    }
    

    @Override
    public boolean reintegro(double dinero) {
        //Primero compruebo si se puede hacer el reintregro
        
        if ( (this.getSaldo()-dinero)<0){
            System.out.println("ERROR cuenta "+this.numero+": Saldo insuficient.");
            return false;
        }
        else{
            this.setSaldo(this.getSaldo()-dinero);
            return true;
        }
    
    }

    @Override
    public boolean transferencia(CuentaBancaria c, double importe) {
        
        if (c instanceof Deposito){
            System.out.println("ERROR: no se puede enviar dinero a un deposito");
            return false;
        }
        
        
        if ( (this.getSaldo()-importe)< 0 ){
            System.out.println("ERROR cuenta "+this.numero+": Saldo insuficiente para transferencia.");
            return false;
        }
        else{
            this.reintegro(importe);
            c.ingreso(importe);
            return true;
            
        }
        
    }

    
}
