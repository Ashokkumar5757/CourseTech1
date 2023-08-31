package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bean.Details;
import Util.DBUtil;

public class EmailDAO {
	public static Connection con;
    public  String link(String course,String level) {
    	 String link=""; 
			try { 
		    con = DBUtil.getConnection();
		    PreparedStatement ps=con.prepareStatement("select link from courselink where course=? and level=?");
		    
		    ps.setString(1,course);
		    ps.setString(2,level);
		  
          ResultSet rst=ps.executeQuery();
          while(rst.next()) {
        	  link=rst.getString("link");
          }
		} catch (Exception e) {
			e.printStackTrace();
		}
       // System.out.print(link);
		return course+"!"+level+"!"+link;
    }

}
