package evrybank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	public static Connection getConnection(){
		Connection con = null;
		
		final String DB_URL = "jdbc:mysql://localhost/evrybankdb";
		final String USER = "evrybankuser";
		final String PASS = "evrybank123";  
		
		try {
			 
		      Class.forName("com.mysql.cj.jdbc.Driver");
	
		      con = DriverManager.getConnection(DB_URL, USER, PASS);
		     
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return con;
	}
}
