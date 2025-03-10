/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fundamentos.*;



/**
 *
 * @author jacuela
 */
public class PruebaFundamenosEntradaSalida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lectura lec = new Lectura ("Prueba de Lectura");

      int i;
      double d;
      String s;
      
      lec.println("Pequeño programa que lee datos gráficamente");
      
      
      lec.creaEntrada("Nombre","");
      lec.creaEntrada("Edad",0);
      lec.creaEntrada("Capacidad pulmonar (l)",0.0);
      lec.esperaYCierra("Introduce datos y pulsa aceptar");
      
      s=lec.leeString("Nombre");
      i=lec.leeInt("Edad");
      d=lec.leeDouble("Capacidad pulmonar (l)");

      Escritura esc = new Escritura ("Prueba de Escritura");

      esc.insertaValor("Nombre",s);
      esc.insertaValor("Edad",i);
      esc.insertaValor("Capacidad pulmonar (l)",d);
      esc.espera();
      System.exit(0);
        
        
        
        
        
    }
    
}
