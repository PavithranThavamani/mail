package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteItems extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Deleted Items</h1>");
		writer.println("<form method='post'>"
				+ "<a href='#'>Open received mails</a><br><br>"
				+ "<a href='./inbox'>Inbox</a><br><br>"
				+ "<a href='./sentitems'>Sent items</a><br><br>"
//				+ "<a href='#'>Deleted items</a><br><br>"
				+ "<a href='./composemail'>Compose mail</a><br><br>"
				+ "<a href='./login'>Logout</a><br><br>"
				+ "</form>");
	}
}