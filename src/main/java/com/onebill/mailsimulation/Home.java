package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Home extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		String user_name = req.getParameter("name_register");
		String email = req.getParameter("email_register");
		String password = req.getParameter("password_register");
//		String toaddress = req.getParameter("toaddress_mail");

		Cookie cookie = new Cookie("username", user_name);
		Cookie cookie2 = new Cookie("email", email);
		Cookie cookie3 = new Cookie("password", password);
//		Cookie cookie4 = new Cookie("toaddress_mail", toaddress);

		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
//		resp.addCookie(cookie4);

		Cookie[] cookies = req.getCookies();

		User_info user = new User_info();
		user.setUser_name(cookies[0].getValue());
		user.setPassword(cookies[2].getValue());
		user.setEmail(cookies[1].getValue());


//		Mail_info mail3 = new Mail_info();
//		mail3.setSubject("speaking");
//		mail3.setMessage("hello?");
//		mail3.setStatus("success");

//		user.setMail_info(Arrays.asList(mail));

		writer.println("<h1>Home</h1>");
//		writer.println("<h1>Hello, "+username+"</h1>");
		writer.println("<form method='post'>" 
				+ "<a href='#'>Open received mails</a><br><br>" 
				+ "<a href='./inbox'>Inbox</a><br><br>"
				+ "<a href='./sentitems'>Sent items</a><br><br>" 
				+ "<a href='./deleteitems'>Deleted items</a><br><br>"
				+ "<a href='./composemail'>Compose mail</a><br><br>" 
				+ "<a href='./login'>Logout</a><br><br>"
				+ "</form>");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mail");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(user);
//		manager.persist(user_info);
		transaction.commit();

		Query query = manager.createQuery("select email from User_info");
		List list = query.getResultList();
		boolean contains = list.contains(req.getParameter("email_register"));
		if(contains != true) {
			writer.println("<h1 style='color:red'>User email already exists!!</h1>");
		}
		
	}

	public static void main(String[] args) {

	}
}
