package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ComposeMail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>COMPOSE MAIL</h1>");
		writer.println("<form action='./sentitems' method='post'>"
				+ "<label>To-address : <label>"
				+ "<input type='text' name='toaddress_mail' required/><br><br>"
				+ "<label>Subject : <label>"
				+ "<input type='text' name='subject_mail'/><br><br>"
				+ "<label>write the content : </label><br><br>"
				+ "<textarea name='content_mail' cols='30' rows='5'></textarea><br><br>"
				+ "<input type='submit' value='Send'/>"
				+ "</form>");
	}
}
