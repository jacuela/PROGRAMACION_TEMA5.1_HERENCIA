/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import ejercicio06.*;
import java.time.LocalDate;

/**
 *
 * @author juan.antonio
 */
public abstract class Vehiculo {
    private String matricula;
    private String marca_modelo;
    protected int km;
    protected boolean alquilado;
    
    
    public Vehiculo(String matricula, String marca_modelo, int km){
        this.matricula=matricula;
        this.marca_modelo=marca_modelo;
        this.km=km;
        this.alquilado=false;
    } 
    
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public String getMarcaModelo(){
        return this.marca_modelo;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public String getMarca_modelo() {
        return marca_modelo;
    }

    public void setMarca_modelo(String marca_modelo) {
        this.marca_modelo = marca_modelo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    
    
    
    
    
    
    @Override
    public String toString(){
        return String.format("%8s %15s [%d km]",this.matricula,this.marca_modelo,this.km);
    }
    
    public abstract void alquilar(LocalDate fecha_alquilerLD, int km);
  
    public abstract void devolver(LocalDate fecha_devolucionLD, int km);
    
    
}
