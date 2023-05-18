/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import ejercicio06.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Furgoneta extends Vehiculo {
    private double precioKM;

    public Furgoneta (String matricula, String marca_modelo, int km){
        super(matricula, marca_modelo, km);
        this.precioKM=0.5;   //0.5 euros cada kilometro
    }

    public Furgoneta(String matricula, String marca_modelo, int km, 
                   boolean alquilado, double precioKM){
       
        super(matricula, marca_modelo, km);
        this.alquilado = alquilado;
        this.precioKM = precioKM;  
    }
    
    
    
    
    
    public double getPrecioKM() {
        return precioKM;
    }

    @Override
    public void alquilar(LocalDate fecha_alquiler, int km){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.alquilado=true; //no es neceario hacerlo pq lo modificamso en la bbdd
        
        Alquiler alquiler=new Alquiler(this);
        alquiler.setFecha_inicio(fecha_alquiler);
        alquiler.setKm_inicio(km);
        
        Empresa.añadirAlquiler(alquiler);
        
        System.out.println("====datos del alquiler====");
        System.out.println("FURGONETA matricula "+this.getMatricula());
        System.out.println("Fecha alquiler: "+fecha_alquiler.format(dtf));
        System.out.println("KM inicio: "+this.km);
        System.out.println("==========================");
    }


    @Override
    public void devolver(LocalDate fecha_devolucionLD, int km) {
      
        this.km = km; //lo hago antes para pasarle el vehiculo con los km correctos

        Empresa.finalizarAlquiler(this, fecha_devolucionLD, km);
    
        
    }
    
    
}
