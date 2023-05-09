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
public class Empleado {
    protected String DNI;
    protected String nombre;
    protected String email;  //no lo utilizo
    protected double salarioBase;
    protected int horasExtra;
    protected int precioHoraExtra;
    
   
    public Empleado(String DNI, String nombre){
        this.DNI=DNI;
        this.nombre=nombre;
        this.salarioBase=1000;
        this.precioHoraExtra=10;
        this.horasExtra=0;
    }
    
    
    public double calcularSueldo(){
        return salarioBase+(horasExtra*precioHoraExtra);
    }
   
    
    @Override
    public String toString(){
        String cadena;
        cadena=String.format("%s (DNI:%s) [EMPLEADO]",this.nombre,this.DNI);
        return cadena;
    }
    
    
    
    //Getter y Seter

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
    
    //fin getter y setter
    
    
    
   
    
    
}
