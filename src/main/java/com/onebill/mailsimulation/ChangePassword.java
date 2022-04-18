package com.onebill.mailsimulation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter writer = resp.getWriter();
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Change Password</h1>");
		writer.println("<form  method='post'>"
				+ "<label>Enter Enter new Password : <label>"
				+ "<input type='text' name='newPassword' required/><br><br>"
				+ "<label>Enter confirm Password : </label>"
				+ "<input type='text' name='confirmPassword' required/><br><br>"
				+ "<input type='submit' value='save'/><br><br>"
				+ "<a href='./login'>Go to login page</a>"
				+ "</form>");
	}
}
