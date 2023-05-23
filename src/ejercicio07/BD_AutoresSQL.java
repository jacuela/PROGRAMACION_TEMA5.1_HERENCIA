/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio07;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class BD_AutoresSQL {
    private static final String URL = "jdbc:mariadb://144.91.104.12:3306/autores";
    private static final String DB_NAME = "";
    private static final String USERNAME = "alumno";
    private static final String PASSWORD = "Administrad0r+";
    private static Connection conexion;

    public BD_AutoresSQL(){
         //this.conectar();
        
    }
    
    public static Connection conectar(){
        
            //***********************************************************
            //    CARGAMOS EL DRIVER
            //***********************************************************
            try {
            
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                //System.out.println("Driver <org.mariadb.jdbc.Driver> cargado.");
            
            } catch (Exception ex) {
                System.out.println("Error, no se ha podido cargar MariaDB JDBC Driver");
            }
        
            
            try {
                //***********************************************************
                //    NOS CONECTAMOS A LA BASE DE DATOS
                //***********************************************************
                
                conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                return conexion;
                
                
                
            } catch (SQLException ex) {
                //System.out.println(ex.getMessage());
                return null;
            }
        
    }
    
    
    public static void cerrarConexion() {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    
    
    public static JSONObject obtenerDatosAutorJSON(String dni_autor) {
        
        JSONObject jsonAutor=null;
        
        try{
            Statement statement = conexion.createStatement();
            String sql=String.format("SELECT nombre,pais FROM autores WHERE dni='%s'",dni_autor);
            //System.out.println("SQL-->"+sql);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                    jsonAutor = new JSONObject();

                    String nombre = rs.getString("nombre");
                    String pais = rs.getString("pais");
                    
                    jsonAutor.put("nombre",nombre);
                    jsonAutor.put("pais",pais);
            }
            
            rs.close();
            statement.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return jsonAutor;
    
    }
    
    
    
}
