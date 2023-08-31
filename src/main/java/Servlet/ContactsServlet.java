package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Contacts;
import DAO.ContactsDAO;

@WebServlet("/ContactsServlet")
public class ContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contacts c=new Contacts();
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		c.setSubject(request.getParameter("subject"));
		c.setMessage(request.getParameter("message"));
		ContactsDAO cd=new ContactsDAO();
		int b=cd.insert(c);
		if(b==1){
			response.sendRedirect("index.html");
		}
		else {
			response.sendRedirect("error.html");
		}
	}

}
