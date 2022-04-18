package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		
		writer.println("<h1>Login</h1>");
		writer.println("<form action='./inbox' method='post'>"
				+ "<label>Enter email : <label>"
				+ "<input type='text' name='email_login' length='25' required/><br><br>"
				+ "<label>Enter Password : </label>"
				+ "<input type='text' name='password_login' required/><br><br>"
				+ "<input type='submit' value='Login'/><br><br>"
				+ "<a href='./changepassword'>Forgot Password?</a><br>"
				+ "New Here? "
				+ "<a href='./register'>Register</a>"
				+ "</form>");
		
		String parameter = req.getParameter("email_login");
		Cookie cookie = new Cookie("email_login", parameter);
		
		Cookie[] cookies = req.getCookies();
		
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mail");
//		EntityManager manager = factory.createEntityManager();
//		Query query = manager.createQuery("select email from User_info");
//		List list = query.getResultList();
////		boolean contains = list.contains(req.getParameter("email_login"));
//		boolean contains = list.contains(cookies[1].getValue());
//		if(contains != true) {
//			writer.println("you are not regsiter yet!!");
//		}
		
	}
}
