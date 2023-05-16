/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06bis_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacuela
 */
public class BD_EmpresaSQL {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/alquilervehiculos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection conexion;
    
    public BD_EmpresaSQL(){
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
    
    
    
    //************************************************************************
    //************************************************************************
    
    public static ArrayList<Vehiculo> getListaVehiculosSQL(){
        
        try {
            ArrayList<Vehiculo> listaVehiculos=new ArrayList();
         
            Statement statement = conexion.createStatement();
          String sql=String.format("SELECT * from vehiculo");
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                    String matricula = rs.getString("matricula");
                    String marca_modelo = rs.getString("marca_modelo");
                    int km = rs.getInt("km");
                    boolean alquilado = rs.getBoolean("alquilado");
                    double precioKilometro = rs.getDouble("precioKilometro");
                    double precioDia = rs.getDouble("precioDia");
                    String tipo = rs.getString("tipoVehiculo");
                    
                    if (tipo.equalsIgnoreCase("turismo")){
                        //Me creo el turismo
                        listaVehiculos.add(new Turismo(matricula,marca_modelo,km,alquilado,precioDia));
                    }
                    
                    if (tipo.equalsIgnoreCase("furgoneta")){
                        //Me creo la furgoneta
                        listaVehiculos.add(new Furgoneta(matricula,marca_modelo,km,alquilado,precioKilometro));
                    }
            }
           
            rs.close();
            statement.close();
            return listaVehiculos;
            
        } catch (SQLException ex) {
            System.out.println("ERROR: sql excepcion");
            System.out.println(ex);
            return null;
        } catch(Exception ex){
            System.out.println("ERROR: excepción");
            System.out.println(ex);
            return null;
        }    
        
    }
    
    
//    public static Equipo getEquipoSQL(int id_equipo){
//        try {
//            Equipo e=null;
//            
//            Statement statement = conexion.createStatement();
//          
//            String sql=String.format("SELECT id,nombre,puntos FROM equipo WHERE id=%d",id_equipo);
//            ResultSet rs = statement.executeQuery(sql);
//            
//            while (rs.next()) {
//                    int id =rs.getInt("id");
//                    String nombre = rs.getString("nombre");
//                    int puntos = rs.getInt("puntos");
//                    
//                    e=new Equipo(id,nombre,puntos);
//            }
//           
//            rs.close();
//            statement.close();
//            return e;
//            
//        } catch (SQLException ex) {
//            System.out.println("ERROR: sql excepcion");
//            System.out.println(ex);
//            return null;
//        }  
//        
//       
//    }
//    
    
    
    
//    public static void actualizarPuntuacionSQL(int id_equipo,int total_puntos){
//        
//        Statement statement;
//        
//        try {
//            statement = conexion.createStatement();
//            String sql=String.format("UPDATE equipo SET puntos=%d WHERE id=%d",total_puntos,id_equipo);
//            statement.executeUpdate(sql);
//            statement.close();
//          
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        
//        }
//        
//    } 
//    
//    public static void resetearSQL(){
//        Statement statement;
//        
//        try {
//            //Borramos puntos
//            statement = conexion.createStatement();
//            String query=String.format("UPDATE equipo SET puntos=0");
//            statement.executeUpdate(query);
//            statement.close();
//        
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        
//        }
//        
//    }
//    
//    
//    
//    public static ArrayList<Jugador> getPlantillaSQL(int id_equipo){
//        
//        
//        try {
//            
//            Statement statement = conexion.createStatement();
//            ArrayList<Jugador> listaJugadores=new ArrayList();
//         
//            //Leemos los jugadores del equipo indicado
//            String sql=String.format("SELECT id,nombre,fecha_nac FROM jugador WHERE id_equipo=%d", id_equipo);
//            ResultSet rs = statement.executeQuery(sql);
//            
//            while (rs.next()) {
//                    int id =rs.getInt("id");
//                    String nombre = rs.getString("nombre");
//                    String fecha = rs.getString("fecha_nac");
//                    LocalDate fecha_nac=LocalDate.parse(fecha);
//                    
//                    //System.out.printf("%d %s %s\n",id, nombre, fecha_nac);
//                   
//                    //Creo un jugador y lo meto en el array
//                    listaJugadores.add(new Jugador(id,nombre,fecha_nac));
//            }
//           
//            rs.close();
//            statement.close();
//            return listaJugadores;
//       
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return null;
//        
//        }
//        
//    }
    
    
   
    
    
    
    
    
}

