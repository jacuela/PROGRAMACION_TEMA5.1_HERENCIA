/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07;

import ejercicio09.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


enum TipoPeriocidad{
    QUINCENAL, MENSUAL, TRIMESTRAL;
}

/**
 *
 * @author juan.antonio
 */
public class Revista extends Publicacion {
    
    private TipoPeriocidad periocidad;
    private LocalDate fechaSalida;
    private ArrayList<LocalDate> numeros;
    
    Revista(String codigo, String titulo, String dni_autor, LocalDate fecha){
        super(codigo,titulo, dni_autor);
        this.periocidad=TipoPeriocidad.MENSUAL;
        this.fechaSalida=fecha;
        numeros=new ArrayList();
        numeros.add(fecha);
    }

    public void setPeriocidad(TipoPeriocidad periocidad) {
        this.periocidad = periocidad;
    }

    
    public void añadirNumero(){
        LocalDate fechaSiguiente;
        LocalDate fechaUltimo;
        
        //Obtengo la fecha del ultimo ejemplar
        //obteniendo el ultimo elemento del arratlist
        fechaUltimo=numeros.get(numeros.size()-1);
        
        if (this.periocidad==TipoPeriocidad.QUINCENAL){
            fechaSiguiente=fechaUltimo.plusWeeks(2);
            numeros.add(fechaSiguiente);
        }
        
        if (this.periocidad==TipoPeriocidad.MENSUAL){
            fechaSiguiente=fechaUltimo.plusMonths(1);
            numeros.add(fechaSiguiente);
        }
        
         if (this.periocidad==TipoPeriocidad.TRIMESTRAL){
            fechaSiguiente=fechaUltimo.plusMonths(3);
            numeros.add(fechaSiguiente);
        }
        
    }
    
    
    
    @Override
    public String toString(){
        String cadena;
        cadena=String.format("REVISTA [%5s] %15s %2d ejemplares - %s",this.codigo,this.titulo,this.numeros.size(),this.periocidad);
        return cadena;
    }
    
    @Override
    public void imprimir() {
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("");
        
        System.out.println("Detalles de REVISTA");
        System.out.println("========================");
        System.out.println("Codigo:"+this.codigo);
        System.out.println("Titulo:"+this.titulo);
        System.out.println("Nombre autor:"+this.nombre_autor);
        System.out.println("Pais autor:"+this.pais_autor);
        System.out.println("Periocidad: "+this.periocidad);
        System.out.println("Total numeros:"+numeros.size());
        for (int i = 0; i < numeros.size(); i++) {
            System.out.printf("  Numero %d -->%s\n",i,numeros.get(i).format(dtf));
        }
    }
   
    
}
