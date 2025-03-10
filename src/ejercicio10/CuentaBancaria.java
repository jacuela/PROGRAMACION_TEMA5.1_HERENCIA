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
public abstract class CuentaBancaria {
    protected int numero;
    protected Persona titular;
    protected double saldo;
    protected LocalDate fechaApertura;
    private static int ultimaCuenta=1000;
    
    public CuentaBancaria(Persona titular, double saldo, LocalDate f){
        this.numero=ultimaCuenta+1;
        ultimaCuenta++;
        this.titular=titular;
        this.saldo=saldo;
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
    
    
    
    public boolean ingreso(double cantidad){
        saldo=saldo+cantidad;
        return true;
    }
   
    @Override
    public String toString(){
        
        String tipocuenta;
        if (this instanceof CuentaCorriente)
            tipocuenta="C.CORRIENTE";
        else if (this instanceof CuentaAhorro)
            tipocuenta="C.AHORRO";
        else
            tipocuenta="DEPOSITO";


        if(saldo>0){
            return String.format("%12s  %5d  \033[34m%10.2f€ \033[30m %10.2f€ - %s\n",tipocuenta,numero,saldo, calcularIntereses(),titular);
        }
        else{
           return String.format("%12s  %5d  \033[31m%10.2f€ \033[30m %10.2f€ - %s\n",tipocuenta,numero,saldo, calcularIntereses(),titular);


        }
    
    }
  
    
    
    protected void mostrarOK(){
        System.out.println("\033[32mOK\033[30m");
    }
    protected void mostrarERROR(){
        System.out.println("\033[31mERROR\033[30m");
    }
    
    
    //Métood abstracto. El reintegro no es igual siempre porque las cuentas
    //de ahorros no permiten descubierto (numeros rojos). Las cuentas corrientes
    //si permiten un límite de descubierto. Y los depósitos no los permiten 
    public abstract boolean reintegro(double dinero);

    public abstract void transferencia(CuentaBancaria c, double importe);
    
    public abstract double calcularIntereses();
    
    
    
}
