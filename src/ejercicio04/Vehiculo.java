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
public abstract class Vehiculo {
    
    private String matricula;
    private String marca_modelo;
    protected int km_motor;
    protected int km_aceite;
    protected int km_ruedas;
    
    
    
    public Vehiculo(String matricula, String marca_modelo){
        this.matricula=matricula;
        this.marca_modelo=marca_modelo;
        this.km_motor=0;
        this.km_aceite=0;
        this.km_ruedas=0;
    } 
    
    public Vehiculo(String matricula, String marca_modelo,int km_motor){
        this.matricula=matricula;
        this.marca_modelo=marca_modelo;
        this.km_motor=km_motor;
        this.km_aceite=0;
        this.km_ruedas=0;
    } 
    
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public String getMarcaModelo(){
        return this.marca_modelo;
    }
    
    public void avanzar(int km){
        this.km_motor=this.km_motor+km;
        this.km_aceite=this.km_aceite+km;
        this.km_ruedas=this.km_ruedas+km;
   
        System.out.println(this);
        System.out.println("    -avanzo"+km+" km.");
        if (checkAceite()) System.out.println("      \033[34mcambio aceitte OK\033[30m");
        if (checkRuedas()) System.out.println("      \033[34mcambio de ruedas OK\033[30m");;
        
    }
    
    @Override
    public String toString(){
        
        return String.format("%s   %s [%d km] ",this.matricula,this.marca_modelo,this.km_motor);
       
    }
    
    public abstract boolean checkAceite();

    public abstract boolean checkRuedas();
    
    
    
}
