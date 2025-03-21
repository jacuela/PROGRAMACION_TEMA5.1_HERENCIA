/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

import java.time.LocalDate;

/**
 *
 * @author jacuela
 */
public class Deposito extends CuentaBancaria {
 
    
    public Deposito(Cliente titular, double saldo, LocalDate fecha){
        super(titular,saldo,fecha);
        
        this.TAE = Banco.getINTERES_DEPOSITO();
   
    }

    
    @Override
    public boolean reintegro(double importe) {
            System.out.println("ERROR cuenta "+this.numero+": Operacion no disponible.");
            return false;
    }

    @Override
    public boolean ingreso(double importe) {
           System.out.println("ERROR cuenta "+this.numero+": Operacion no disponible.");
            return false;
    }
    

    @Override
    public boolean transferencia(CuentaBancaria c, double importe) {
        System.out.println("ERROR cuenta "+this.numero+": Operacion no disponible.");
        return false;
    }

    
    
}
