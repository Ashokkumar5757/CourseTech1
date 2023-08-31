package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.Details;
import Util.DBUtil;


public class DetailsDAO {
	public static Connection con;
    public static int insert(Details d) {
    	 int b=0;
			try { 
		    con = DBUtil.getConnection();
		    PreparedStatement pst = con.prepareStatement("insert into details(name,email,number,course,level) values(?,?,?,?,?)");
			pst.setString(1, d.getName());
	        pst.setString(2, d.getEmail());
	        pst.setString(3, d.getPhno());
	        pst.setString(4, d.getCourse());
	        pst.setString(5, d.getLevel());
	        b=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return b;
    }
}
