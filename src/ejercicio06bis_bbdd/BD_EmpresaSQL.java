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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

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
    
    
    //************************************************************************
    public static void añadirVehiculo(Vehiculo v) {
        String sql=null;
       
        
        
        //Primero, veo que tipo de vehiculo es
        if (v instanceof Turismo){
            Turismo t = (Turismo)v;
            sql=String.format(Locale.ROOT,"INSERT INTO vehiculo VALUES ('%s','%s',%d,false,null,%.2f,'turismo')",
                                                            t.getMatricula(),
                                                            t.getMarcaModelo(),
                                                            t.getKm(),
                                                            t.getPrecioDia());
        }
        if (v instanceof Furgoneta){
            Furgoneta f = (Furgoneta)v;

            sql=String.format(Locale.ROOT,"INSERT INTO vehiculo VALUES ('%s','%s',%d,false,%.2f,null,'furgoneta')",
                                                            f.getMatricula(),
                                                            f.getMarcaModelo(),
                                                            f.getKm(),
                                                            f.getPrecioKM());
        }

            
        try {
            Statement statement = conexion.createStatement();
            System.out.println("quiery:"+sql);
            statement.executeUpdate(sql);
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("ERROR: sql excepcion");
            System.out.println(ex);
        }  


    }
    
    
    
    //************************************************************************
    
    static Vehiculo obtenerVehiculo(String matricula_) {
        
        try {
            Vehiculo v=null;
            
            Statement statement = conexion.createStatement();
            String sql=String.format("SELECT * FROM vehiculo WHERE matricula='%s'",matricula_);
            //System.out.println("SQL-->"+sql);
            ResultSet rs = statement.executeQuery(sql);
            
            
            while (rs.next()) {
                    String matricula = rs.getString("matricula");
                    String marca_modelo = rs.getString("marca_modelo");
                    int km = rs.getInt("km");
                    boolean alquilado = rs.getBoolean("alquilado");
                    double precioKM = rs.getDouble("precioKilometro");
                    double precioDIA = rs.getDouble("precioDia");
                    String tipo = rs.getString("tipoVehiculo");
                    
                    if (tipo.equals("turismo")){
                        //Es un turismo
                        v=new Turismo(matricula,marca_modelo,km,alquilado,precioDIA);
                    }
                    else{
                       //Es una furgoneta 
                       v=new Furgoneta(matricula,marca_modelo,km,alquilado,precioKM);

                    }

            }
           
            rs.close();
            statement.close();
            return v;
            
        } catch (SQLException ex) {
            System.out.println("ERROR: sql excepcion");
            System.out.println(ex);
                
            return null;
        }  
        
        
    }
    
    //************************************************************************
    
    
    public static void setCampoAlquilado(String matricula, boolean alquilado) {
    
        Statement statement;
        
        try {
            statement = conexion.createStatement();
            String sql=String.format("UPDATE vehiculo SET alquilado=%s WHERE matricula='%s'",alquilado,matricula);
            statement.executeUpdate(sql);
            statement.close();
          
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
    
    }

    
    //************************************************************************
    
    
    public static void actualizarKmVehiculo(String matricula, int km) {
        Statement statement;
        
        try {
            statement = conexion.createStatement();
            String sql=String.format("UPDATE vehiculo SET km=%d WHERE matricula='%s'",km,matricula);
            statement.executeUpdate(sql);
            statement.close();
          
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
        
    }

    
   
    public static void añadirAlquiler(Alquiler a) {
        
        String sql=String.format(Locale.ROOT,"INSERT INTO alquiler VALUES (null,'%s',%d,%d,'%s',null,%.2f)",
                                a.getVehiculo().getMatricula(),
                                a.getKm_inicio(),
                                a.getKm_fin(),
                                a.getFecha_inicio(),
                                a.getImporte()
                          );
            
        try {
            Statement statement = conexion.createStatement();
            //System.out.println("quiery:"+sql);
            statement.executeUpdate(sql);
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("ERROR: sql excepcion");
            System.out.println(ex);
        }  

        
    }
    
    //************************************************************************
    
    public static int obtenerIDAlquilerSinTerminar(Vehiculo vehiculo) {
        
        try {
            
            int id=-1;
            Statement statement = conexion.createStatement();
            String sql=String.format("SELECT id FROM alquiler WHERE vehiculo='%s' and fecha_fin is null",
                                                    vehiculo.getMatricula());
            //System.out.println("SQL-->"+sql);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                    id = rs.getInt("id");
            }
            
            rs.close();
            statement.close();
            return id;
            
        } catch (SQLException ex) {
            System.out.println("ERROR en: obtenerIDAlquilerSinTerminar()");
            System.out.println(ex);
                
            return -1;
        }  
        
    
    }
    
    //************************************************************************
    
    public static void finalizarAlquiler(int id_alquiler, LocalDate fecha_devolucionLD, int km, double importe) {
      
        Statement statement;
        String sql;
        
        try {
            statement = conexion.createStatement();
            
            sql=String.format("UPDATE alquiler SET km_fin=%d WHERE id=%d",km,id_alquiler);
            statement.executeUpdate(sql);
            
            sql=String.format("UPDATE alquiler SET fecha_fin='%s' WHERE id=%d",fecha_devolucionLD,id_alquiler);
            statement.executeUpdate(sql);
            
            sql=String.format(Locale.ROOT,"UPDATE alquiler SET importe='%.2f' WHERE id=%d",importe,id_alquiler);
            statement.executeUpdate(sql);
            
            statement.close();
          
        } catch (SQLException ex) {
            System.out.println(ex);
        
        }
        
        
    }

    
     //************************************************************************
    
    
    
    public static Alquiler obtenerAlquiler(int id_, Vehiculo vehiculo) {
        
        try {
            
            Alquiler a=null;
            Statement statement = conexion.createStatement();
            String sql=String.format("SELECT * FROM alquiler WHERE id=%d",id_);
            //System.out.println("SQL-->"+sql);
            ResultSet rs = statement.executeQuery(sql);
            
            
            while (rs.next()) {
                    int id = rs.getInt("id");
                    //String matricula = rs.getString("matricula");
                    int km_inicio = rs.getInt("km_inicio");
                    int km_fin = rs.getInt("km_fin");
                    String fecha_inicio = rs.getString("fecha_inicio");
                    LocalDate fecha_inicioLD = LocalDate.parse(fecha_inicio);
                    
                    String fecha_fin = rs.getString("fecha_fin");
                    LocalDate fecha_finLD;
                    if (fecha_fin!=null){
                        fecha_finLD = LocalDate.parse(fecha_fin);
                    }
                    else{
                        fecha_finLD=null;
                    }
                    
                    double importe = rs.getDouble("importe"); //será cero
                    
                    a=new Alquiler(id,vehiculo,km_inicio,km_fin,fecha_inicioLD,fecha_finLD,importe);

            }
           
            rs.close();
            statement.close();
            return a;
            
        } catch (SQLException ex) {
            System.out.println("ERROR en: obtenerAlquiler()");
            System.out.println(ex);
                
            return null;
        }  
        
    
    }
    
    
    //************************************************************************
    
    public static JSONArray obtenerListaAlquileresJSON() {
        
        JSONArray jsonListaAlquileres = new JSONArray();
        try{
            Statement statement = conexion.createStatement();
            String sql=String.format("SELECT * FROM alquiler");
            //System.out.println("SQL-->"+sql);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                    
                    JSONObject jsonAlquiler = new JSONObject();

                    int id = rs.getInt("id");
                    String matricula = rs.getString("matricula");
                    int km_inicio = rs.getInt("km_inicio");
                    int km_fin = rs.getInt("km_fin");
                    String fecha_inicio = rs.getString("fecha_inicio");
                    LocalDate fecha_inicioLD = LocalDate.parse(fecha_inicio);
                    
                    String fecha_fin = rs.getString("fecha_fin");
                    LocalDate fecha_finLD;
                    if (fecha_fin!=null){
                        fecha_finLD = LocalDate.parse(fecha_fin);
                    }
                    else{
                        fecha_finLD=null;
                    }
                    
                    double importe = rs.getDouble("importe"); //será cero
                    
                    jsonAlquiler.put("id",id);
                    jsonAlquiler.put("matricula",matricula);
                    jsonAlquiler.put("fecha_inicio",fecha_inicio);
                    jsonAlquiler.put("fecha_fin",fecha_fin);
                    jsonAlquiler.put("km_inicio",km_inicio);
                    jsonAlquiler.put("km_fin",km_fin);
                    jsonAlquiler.put("importe",importe);
                    
                    jsonListaAlquileres.put(jsonAlquiler);
                           
            }
            
            
            rs.close();
            statement.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return jsonListaAlquileres;
    
    }

    
    
    
    
    //************************************************************************

    
    
   
    
    
    
    
    
}

