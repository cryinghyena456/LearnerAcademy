package com.learner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String user = 	 req.getParameter("user");
		String pass = req.getParameter("pass");
		String ouser = "admin";
		String opass = "admin";
		
		System.out.println(user);
		System.out.println(pass);
		if(user.equalsIgnoreCase(ouser)==true) {
			if(pass.equalsIgnoreCase(opass)==true) {
				resp.sendRedirect("/LearnerPortal/Dashboard.jsp");
				
			}
			else {
				PrintWriter writer = resp.getWriter();
				writer.println("Wrong input");
				resp.sendRedirect("/LearnerPortal/index.html");
				
			}
		}
		else {
			PrintWriter writer = resp.getWriter();
			writer.println("Wrong input");
			resp.sendRedirect("/LearnerPortal/index.html");
		
	}
	}
}
