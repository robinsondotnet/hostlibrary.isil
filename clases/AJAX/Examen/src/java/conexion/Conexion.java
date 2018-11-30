/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

//PATRON SINGLETON

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {

private static Conexion instancia;
private Connection con;
private String url="jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=mantenimiento2";
private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
private String usuario="SA";
private String clave="123456";

    private Conexion() {
    
    try {
        Class.forName(driver);
        con=DriverManager.getConnection(url,usuario,clave);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    public synchronized static Conexion conectar(){
    
        if (instancia==null) {
            instancia=new Conexion();
        }
    return instancia;
    
    }
    public Connection getCon() {
        return con;
    }
    public void cerrarConexion(){
        instancia=null;
    }

}