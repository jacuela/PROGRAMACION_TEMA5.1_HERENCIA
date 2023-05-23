/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio07;

import ejercicio06bis_bbdd.BD_EmpresaSQL;
import ejercicio09.*;
import org.json.JSONObject;

/**
 *
 * @author juan.antonio
 */
public abstract class Publicacion {
    protected String codigo;
    protected String titulo;
    protected String dni_autor;
    protected String nombre_autor;
    protected String pais_autor;
    
    
    //Constructor1. 
    Publicacion(String codigo, String titulo, String dni_autor){
        this.codigo = codigo;
        this.titulo=titulo;
        this.dni_autor=dni_autor;
        
        //Valores por defecto si no me conecto a la bbdd
        this.nombre_autor = "sin datos";
        this.pais_autor = "sin datos";
        
        
        //Obtenemso de la bbdd los datos del autor
        if (BD_AutoresSQL.conectar()==null){ 
            System.out.println("\033[31mERROR en la conexión de la bbdd\033[30m");
        }
        else{
            JSONObject jsonAutor=BD_AutoresSQL.obtenerDatosAutorJSON(dni_autor);
            if (jsonAutor!=null){
                this.nombre_autor = jsonAutor.getString("nombre");
                this.pais_autor = jsonAutor.getString("pais");
                System.out.println("\033[32m..datos de autor encontrados en la bbdd..\033[30m");
                BD_AutoresSQL.cerrarConexion();
            }
            else{
                System.out.println("ERROR: autor no encontrado en la BBDD");
            }
        }
        
        
        
    } 
    
    
    //getter and setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    ///////////////////
    
    
    public abstract void imprimir();
    
}


