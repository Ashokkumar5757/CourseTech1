package Servlet;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Details;
import DAO.EmailDAO;


@WebServlet("/Getotp")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String link="";
	public static void demo(String s) {
		link=s;
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hey you!");
		Details d = new Details();
		EmailDAO ed=new EmailDAO();
		String ar[]=link.split("!");
		String email = request.getParameter("email");
        request.getSession();
        RequestDispatcher dispatcher = null;
		if(email!=null || !email.equals("")) {
			String to = email;
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("coursetech01@gmail.com", "rbju glkw hdpe mbok");}});
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Hello Learner!!!");
				message.setText("Your Test Link for Course "+ar[0]+" and Level "+ar[1]+" is: \n"+ar[2]);
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
				}
			catch (MessagingException e) {
				throw new RuntimeException(e);	
				}
			}
	}
		
   }

