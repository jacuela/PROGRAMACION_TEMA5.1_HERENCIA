/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02bis;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class UsuAdmin extends UsuNormal {
    
    public UsuAdmin (String nombre, String password, String email){
       super(nombre,password,email); 
    }
    
    
    @Override
    public String toString(){
        return String.format("A%2d %10s %10s %s",this.id,this.nombre,this.password,this.email);
        
        //return String.format("A%s",super.toString());
        
    }
    
    //El método cambiarPassword() lo hereda tal cual
    
    //Método para cambiar el password de cualquier usuario
    public void cambiarPassword(int id){
        
        //1º: obtengo el usuario con dicho id
        //2º: llamo a su método .cambiarPassword()
        
        
    }
    
    
    
    
}
