
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class PruebaSeparadorDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
//        String sql=String.format(Locale.ROOT,"INSERT INTO tabla VALUES ('%s',%d,%.2f,'dato')",
//                "1111TTT",
//                1000,
//                0.5);
        
           Locale.
        String sql=String.format("INSERT INTO tabla VALUES ('%s',%d,%.2f,'dato')",
                "1111TTT",
                1000,
                0.5);

        System.out.println("sql:"+sql);
        
        
    }
    
}
