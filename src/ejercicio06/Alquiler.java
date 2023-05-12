/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author juan.antonio
 */
public class Alquiler {
    private Vehiculo vehiculo;
    private int km_inicio;
    private int km_fin;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private double importe;
    
    public Alquiler(Vehiculo v){
        this.vehiculo=v;
        this.km_inicio=0;
        this.km_fin=0;
        this.fecha_inicio=null;
        this.fecha_fin=null;
        this.importe=0.0;
        
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
 
    public int getKm_inicio() {
        return km_inicio;
    }

    public void setKm_inicio(int km_inicio) {
        this.km_inicio = km_inicio;
    }

    public int getKm_fin() {
        return km_fin;
    }

    public void setKm_fin(int km_fin) {
        this.km_fin = km_fin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    public double calcularImporte(){
        Furgoneta unaFurgoneta;
        Turismo unTurismo;
        
        if (vehiculo instanceof Furgoneta){
            unaFurgoneta=(Furgoneta)vehiculo;
            this.importe=(km_fin-km_inicio)*unaFurgoneta.getPrecioKM();
            return importe;
        }
        if (this.vehiculo instanceof Turismo){
            unTurismo=(Turismo)vehiculo;
            long diasAlquiler=calcularDias();
            this.importe=diasAlquiler*unTurismo.getPrecioDia();
            return importe;
        }
        
        return -1;
    }  

    public void imprimir(){
        
        if (this.vehiculo instanceof Furgoneta){
            System.out.println("******************");
            System.out.println(this.vehiculo);
            System.out.println("KM realizados: "+(this.km_fin-this.km_inicio));
            System.out.println("Precio: "+((Furgoneta)vehiculo).getPrecioKM()+"€/Km");
            System.out.println("IMPORTE: "+this.importe+"€");
            System.out.println("*******************");
        }
        
        if (this.vehiculo instanceof Turismo){
            System.out.println("******************");
            System.out.println(this.vehiculo);
            System.out.println("Días alquiler: "+(this.calcularDias()));
            System.out.println("Precio: "+((Turismo)vehiculo).getPrecioDia()+"€/día");
            System.out.println("IMPORTE: "+this.importe+"€");
            System.out.println("*******************");
        }
        
    }
    
    //************************************
    //*************************************
    //Pendiente de programar
    //***********************************
    private long calcularDias() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        long dias = ChronoUnit.DAYS.between(this.fecha_inicio, this.fecha_fin);
        //System.out.println("\n<Dias> entre las dos fechas: "+dias); 
        
        return dias;
    }
    
    
    
    @Override
    public String toString(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String a;
        if (this.importe==0){
          a=String.format("%10s - %10s - NO FINALIZADO", this.vehiculo.getMatricula(),this.fecha_inicio); 
            
        }
        else{
          a=String.format("%10s - %10s - %f €", this.vehiculo.getMatricula(),this.fecha_inicio,this.importe);
        }
       
        return a;
        
    }
    
    
    
}
