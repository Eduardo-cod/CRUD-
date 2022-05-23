/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public boolean ejecutarSentenciaSql(String strSentenciaSql){
        try {
            PreparedStatement prepared = con.prepareStatement(strSentenciaSql);
            prepared.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
            
    }
    
    public ResultSet consultarRegistros(String strSentenciaSql){
        try {
            
            PreparedStatement patm = con.prepareStatement(strSentenciaSql);
            ResultSet respuesta = patm.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            
            System.out.println(e);
            return null;
            
        }
    }
    
}
