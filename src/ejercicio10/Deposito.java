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
public class Deposito extends CuentaBancaria {

    private double interes;
    
    public Deposito(Persona titular, double saldo, LocalDate fecha){
        super(titular,saldo,fecha);
        interes=5;  //El interes es porcentaje, en este caso 5%
    }

    
    @Override
    public boolean reintegro(double importe) {
            System.out.println("Error. Operacion no disponible.");
            return false;
    }

    @Override
    public boolean ingreso(double importe) {
            System.out.println("Error. Operacion no disponible.");
            return false;
    }

    

    @Override
    public void transferencia(CuentaBancaria c, double importe) {
        System.out.println("Error. Operacion no disponible.");
    }

    @Override
    public double calcularIntereses() {
        long años=ChronoUnit.YEARS.between(fechaApertura, LocalDate.now());
        return saldo*(interes/100)*años;

    }
    
}
