package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SentItems extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		String to_address = req.getParameter("toaddress_mail");
		String subject = req.getParameter("subject_mail");
		String message = req.getParameter("content_mail");

		Mail_info mail = new Mail_info();
		mail.setSubject(subject);
		mail.setMessage(message);
		mail.setStatus("success");
		
		User_info user_info = new User_info();
		user_info.setMail_info(Arrays.asList(mail));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mail");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Query createQuery = manager.createQuery("select count(*) from Mail_info");
//		Query messages = manager.createQuery("select Message from Mail_info");
//		Query createQuery = manager.createQuery("select count(*) from Mail_info");
		
//      for (Employee employee : list) {
//			System.out.println(employee);
//		}
		transaction.begin();
		manager.persist(mail);
		transaction.commit();

		writer.println("<h1>Sent Items</h1>");
		writer.println(""
				+ "<h3>sent mails</h3>");
		Mail_info find = manager.find(Mail_info.class, 1);
		
		System.out.println(createQuery.getSingleResult());
		System.out.println(find);
		Query messages = manager.createQuery("select message from Mail_info");
		List<Mail_info> list = messages.getResultList();
		Iterator<Mail_info> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
//		System.out.println(list);

		writer.println("<form method='post'>" + "<a href='#'>Open received mails</a><br><br>"
				+ "<a href='./inbox'>Inbox</a><br><br>"
				+ "<a href='./deleteitems'>Deleted items</a><br><br>"
				+ "<a href='./composemail'>Compose mail</a><br><br>" + "<a href='./login'>Logout</a><br><br>"
				+ "</form>");
	}
	
	
}
