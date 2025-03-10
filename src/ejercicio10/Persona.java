/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

/**
 *
 * @author jacuela
 */
public class Persona {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String email;
    
    public Persona(String dni, String nombre, String apellidos, String email){
        this.DNI=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.email=email;
    }
  
    @Override
    public String toString(){
        return nombre+" "+apellidos+" ["+DNI+"]";
    }
    
    
}
