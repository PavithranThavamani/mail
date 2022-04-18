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
public class Inbox extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
//		Cookie[] cookies = req.getCookies();
//		String value = cookies[1].getValue();
//		String value2 = cookies[2].getValue();
//		String value3 = cookies[3].getValue();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mail");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select email from User_info");
		Query query2 = manager.createQuery("select password from User_info");
		List list = query.getResultList();
		List list2 = query2.getResultList();
		boolean contains = list.contains(req.getParameter("email_login"));
		if(contains != true) {
			writer.println("<h1 style='color:red'>you did not regsiter yet!!, Register first..</h1>");
		} else {
			boolean contains2 = list2.contains(req.getParameter("password_login"));
			if(contains2 != true) {
				writer.println("<h1 style='color:red';>Invalid email or password</h1>");
			}
		}
		writer.println("<h1>Inbox</h1>");
		writer.println("<form method='post'>" + 
				"<a href='#'>Open received mails</a><br><br>"
//				+ "<a href='#'>Inbox</a><br><br>"
				+ "<a href='./sentitems'>Sent items</a><br><br>" 
				+ "<a href='./deleteitems'>Deleted items</a><br><br>"
				+ "<a href='./composemail'>Compose mail</a><br><br>" 
				+ "<a href='./login'>Logout</a><br><br>"
				+ "</form>");
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mail");
//		EntityManager manager = factory.createEntityManager();
//		Query query = manager.createQuery("select email from User_info");
//		List list = query.getResultList();
//		boolean contains = list.contains(req.getParameter("email_login"));
//		if(contains != true) {
//			writer.println("<h1>you are not regsiter yet!!</h1>");
//		}
		
	}
	
			
}
