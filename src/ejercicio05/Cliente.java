/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05;

/**
 *
 * @author jacuela
 */
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellidos;
    
    
    public Cliente(String dni, String nombre, String apellidos){
        this.DNI=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        
    }
  
    @Override
    public String toString(){
        return nombre+" "+apellidos+" ["+DNI+"]";
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
    
    
    
    
    
    
    
}
