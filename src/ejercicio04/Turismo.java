/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04;

/**
 *
 * @author jacuela
 */
public class Turismo extends Vehiculo {
    

    public Turismo(String matricula, String marca_modelo) {
        super(matricula, marca_modelo);
        
    }

    public Turismo(String matricula, String marca_modelo, int km_motor) {
        super(matricula, marca_modelo, km_motor);
    }
    
    
    @Override
    public boolean checkAceite() {
        
        if (this.km_aceite>=15000){
            this.km_aceite=0;
            return true;
        }
        else{
            return false;
        }
        
    }

    @Override
    public boolean checkRuedas() {
        
        if (this.km_ruedas>=30000){
            this.km_ruedas=0;
            return true;
        }
        else{
            return false;
        }
        
    }
   
    
    
}
