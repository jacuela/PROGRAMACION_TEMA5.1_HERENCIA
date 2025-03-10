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
public class Director extends Empleado {
    private int numDespacho;
    private double plusSalario;
    
    public Director(String DNI, String nombre, int numDespacho) {
        super(DNI, nombre);
        this.numDespacho=numDespacho;
        this.plusSalario=400;
        this.precioHoraExtra=20;
        
    }
    
    @Override
    public double calcularSueldo(){
       // Opccion1. Llamara al método del padre 
       double sueldoBase=super.calcularSueldo();
       return sueldoBase+plusSalario;
        
        
       //Opcion2. Usar miembros protegidos
       //return salarioBase+(horasExtra*precioHoraExtra)+plusSalario;
        
        
    }
    
    public void analizarDatos(){
        System.out.println("Analizando datos....");
        
    }
    
    
    
    

    //Getter y setter
    public int getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(int numDespacho) {
        this.numDespacho = numDespacho;
    }
    
    // fin getter y setter
    
    
    
    
}
