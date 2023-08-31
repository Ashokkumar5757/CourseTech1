package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.Contacts;
import Util.DBUtil;

public class ContactsDAO {
	public static Connection con;
    public static int insert(Contacts d) {
    	 int b=0;
			try { 
		    con = DBUtil.getConnection();
		    PreparedStatement pst = con.prepareStatement("insert into contacts(name,email,subject,message) values(?,?,?,?)");
			pst.setString(1, d.getName());
	        pst.setString(2, d.getEmail());
	        pst.setString(3, d.getSubject());
	        pst.setString(4, d.getMessage());
	        b=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return b;
    }
}
