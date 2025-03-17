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
public class Camion extends Vehiculo {

    private int km_tacografo;

    public Camion(String matricula, String marca_modelo) {
        super(matricula, marca_modelo);
        this.km_tacografo = 0;
    }

    public Camion(String matricula, String marca_modelo, int km_motor) {
        super(matricula, marca_modelo, km_motor);
        this.km_tacografo = 0;
    }
    
    
    @Override
    public void avanzar(int km){
        
        //Este metodo hace lo mismo que en el padre solo que
        //le añade km al tacografo y lo chequea.
        //Podemos llamar al metodo del padre con la palabra super.
        
        
        //Llamamos al método avanzar del padre con los km proporcionados
        super.avanzar(km);
        
        //Y hacemos lo extra del camion
        
        this.km_tacografo=this.km_tacografo+km;
        if (checkTacografo()) System.out.println("      \033[34mtacógrafo revisado OK\033[30m");;
        
        
    }
    
    @Override
    public boolean checkAceite() {
        
        if (this.km_aceite>=30000){
            this.km_aceite=0;
            return true;
        }
        else{
            return false;
        }
        
    }

    @Override
    public boolean checkRuedas() {
        
        if (this.km_ruedas>=50000){
            this.km_ruedas=0;
            return true;
        }
        else{
            return false;
        }
        
    }
   
    public boolean checkTacografo(){
        if (this.km_tacografo>=50000){
            this.km_tacografo=0;
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
