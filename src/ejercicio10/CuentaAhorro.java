/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jacuela
 */
public class CuentaAhorro extends CuentaBancaria {
    private double interes;
    
    public CuentaAhorro(Persona titular, double saldo, LocalDate fecha){
        super(titular,saldo,fecha);
        interes=0.5;  //El interes es porcentaje, en este caso 0.5%
    }

    

    @Override
    public boolean reintegro(double dinero) {
        //Primero compruebo si se puede hacer el reintregro
        
        if ( (this.getSaldo()-dinero)<=0){
            this.mostrarERROR();
            System.out.println("Saldo insuficiente.");
            return false;
        }
        else{
            this.setSaldo(this.getSaldo()-dinero);
            this.mostrarOK();
            return true;
        }
    
    }

    @Override
    public void transferencia(CuentaBancaria c, double importe) {
        
        if ( (this.getSaldo()-importe)< 0 ){
            this.mostrarERROR();
            System.out.println("Saldo insuficiente.");
        }
        else{
            this.reintegro(importe);
            c.ingreso(importe);
            this.mostrarOK();
        }
        
//        //Otra forma de hacer la transferencia es llamando al metodo reintegro
//        if (this.reintegro(importe)){
//             c.ingreso(importe);
//        }
//     
        
    }

    @Override
    public double calcularIntereses() {
        
        long meses=ChronoUnit.MONTHS.between(fechaApertura, LocalDate.now());
        //System.out.println("Meses de intereses:"+meses);
        return saldo*(interes/100)*meses;
   
    }
}
