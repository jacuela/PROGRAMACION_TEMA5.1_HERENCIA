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
public class Turismo extends Vehiculo {

    private double precioDia;
    
    public Turismo(String matricula, String marca_modelo, int km){
        super(matricula, marca_modelo, km);
        this.precioDia=30;   //30 euros cada día
    }
    
    public Turismo(String matricula, String marca_modelo, int km, 
                   boolean alquilado, double precioDia){
       
        super(matricula, marca_modelo, km);
        this.alquilado = alquilado;
        this.precioDia=precioDia;  
    }
    
    
    
    
    

    public double getPrecioDia() {
        return precioDia;
    }
    

    @Override
    public void alquilar(LocalDate fecha_alquiler, int km){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.alquilado=true;
        Alquiler alquiler=new Alquiler(this);
        alquiler.setFecha_inicio(fecha_alquiler);
        alquiler.setKm_inicio(km);
        //Añadir este alquiler a la bd
        Empresa.añadirAlquiler(alquiler);
        
        System.out.println("====datos del alquiler====");
        System.out.println("TURISMO matricula "+this.getMatricula());
        System.out.println("Fecha alquiler: "+fecha_alquiler.format(dtf));
        System.out.println("KM inicio: "+this.km);
        System.out.println("==========================");

    }
    
    
    @Override
    public void devolver(LocalDate fecha_devolucionLD, int km) {
        Alquiler a=Empresa.obtenerUltimoAlquiler(this.getMatricula());
        
        a.setFecha_fin(fecha_devolucionLD);
        a.setKm_fin(km);
        a.calcularImporte();
        this.alquilado=false;
        
        //Muestro los datos del aquiler
        a.imprimir();
        
        //FINALMENTE, hay que actualizar los km del vehiculo
        this.km=km;
        
    }
    
    
    
    
}
