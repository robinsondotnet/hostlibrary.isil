package proy.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
 
public class DBConn{

	private static String driver = null;
	private static String usuario = null;
	private static String password = null;
	private static String url = null;
	static PropertyResourceBundle properties;

        static {
        try {
            ResourceBundle properties = ResourceBundle.getBundle("proy.util.datos");

            url = properties.getString("URL");
            driver = properties.getString("DRIVER");
            usuario = properties.getString("USER");
            password = properties.getString("PASSWORD");

            Class.forName(driver);

        } catch (Exception e) {
        }
        }

public static Connection getConnection() {
	Connection connection=null;
	try{
		connection = DriverManager.getConnection(url,usuario,password);
	}
	catch(SQLException e){
		//Error en base de datos no se puede lograr la conexion
	    System.out.println("Error:"+e);
	}		
	return connection;
}

}