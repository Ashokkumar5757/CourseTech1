package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Details;
import DAO.DetailsDAO;
import DAO.EmailDAO;

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Details d=new Details();
		d.setName(request.getParameter("name"));
		d.setEmail(request.getParameter("email"));
		d.setPhno(request.getParameter("number"));
		d.setCourse(request.getParameter("course"));
		d.setLevel(request.getParameter("level"));
		DetailsDAO dd=new DetailsDAO();
		EmailServlet em=new EmailServlet();
		EmailDAO ed=new EmailDAO();
		String link=ed.link(d.getCourse(),d.getLevel());
		em.demo(link);
		em.doGet(request,response);
		int b=dd.insert(d);
		if(b==1){
			response.sendRedirect("index.html");
		}
		else {
			response.sendRedirect("error.html");
		}
	}
       
}
