package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		
		writer.println("<h1>Register</h1>");
		writer.println("<form action='./home' method='post'>"
				+ "<label>Enter Username : <label>"
				+ "<input type='text' name='name_register' required/><br><br>"
				+ "<label>Enter email : <label>"
				+ "<input type='text' name='email_register' required/><br><br>"
				+ "<label>Enter Password : </label>"
				+ "<input type='text' name='password_register' required/><br><br>"
				+ "<input type='submit' value='Register'/>"
				+ "</form>");
		
		
	}
}
