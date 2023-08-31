package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
     public static Connection con=null;
	   public static Connection getConnection(){
		   try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
		}		   
		return con;	
	   }
}
