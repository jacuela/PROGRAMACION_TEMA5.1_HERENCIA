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
public abstract class CuentaBancaria {
    protected int numero;
    protected Cliente titular;
    protected double saldo;
    protected LocalDate fechaApertura;
    protected double TAE;
    
    private static int ultimaCuenta=1000;
    
    public CuentaBancaria(Cliente titular, double saldo_inicial, LocalDate f){
        this.numero=ultimaCuenta+1;
        ultimaCuenta++;
        this.titular=titular;
        this.saldo=saldo_inicial;
        this.fechaApertura=f;
        
    }
    
    
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double dinero){
        saldo=dinero;
    }
    
    public int getNumero(){
        return numero;
    }
    
    
    
    @Override
    public String toString(){
        
        String tipocuenta;
        if (this instanceof CuentaCorriente)
            tipocuenta="C.CORRIENTE";
        
        else
            tipocuenta="DEPOSITO";

        
        return String.format("%12s %5d %7s %10.2f€ %10.2f€\n",tipocuenta,numero,titular.getNombre(),saldo, calcularIntereses());
        
       
    
    }
    
    
    
    public double calcularIntereses() {
    
        //Se calculan por meses, pero el TAE es anual
        
        long meses=ChronoUnit.MONTHS.between(fechaApertura, LocalDate.now());
        //System.out.println("       ------Meses de intereses:"+meses);
        
        double TAE_mensual = this.TAE / 12;
        
        return saldo*((TAE_mensual/100)*meses);
   
                
    }
    
    //Métodos abstractos
    public abstract boolean reintegro(double importe);
    
    public abstract boolean ingreso(double importe);

    public abstract boolean transferencia(CuentaBancaria c, double importe);
    
    
    
}
