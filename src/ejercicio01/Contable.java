/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio01;

/**
 *
 * @author jacuela
 */
public class Contable extends Empleado {
    
    private double plusSalario;
    
    
    public Contable(String DNI, String nombre) {
        super(DNI, nombre);
        this.plusSalario=200;
        
    }
    
    
    
    @Override
    public double calcularSueldo(){
       
       // Opccion1. Llamara al método del padre 
       // double sueldoBase=super.calcularSueldo();
       // return sueldoBase+plusSalario;
        
        
       //Opcion2. Usar miembros protegidos
        return salarioBase+(horasExtra*precioHoraExtra)+plusSalario;
        
    }
    
    
    public void contabilizar(){
        System.out.println("Estoy contabilizando...");
        
    }
    
//    @Override
//    public String toString(){
//        String cadena;
//        cadena=String.format("%s (DNI:%s) [CONTABLE]",this.nombre,this.DNI);
//        return cadena;
//    }
    
    
    
}
