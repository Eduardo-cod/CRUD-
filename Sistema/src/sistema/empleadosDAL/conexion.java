/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Eduardo
 */
public class conexion {
    
    String strConexionDB = "jdbc:sqlite:C:/Users/eduar/Documents/db/sistema.s3db";
    Connection con = null;
    
    public conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(strConexionDB);
            
            System.out.println("conexion establecida");
            
        } catch (Exception e) {
            System.out.println("Error de conexion"+e);
        }
    }
}
