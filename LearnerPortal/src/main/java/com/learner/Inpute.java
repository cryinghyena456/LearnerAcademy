package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Inpute")
public class Inpute extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name = arg0.getParameter("name");
		String cls = arg0.getParameter("cls"); 
		String age = arg0.getParameter("age");
		String tname = arg0.getParameter("tname");
		String subject = arg0.getParameter("subject");
		String tage = arg0.getParameter("tage");
	    RequestDispatcher disp = null;
		PrintWriter writer = arg1.getWriter();
		Connection con = null;
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
		PreparedStatement pstmt = con.prepareStatement("insert into db (name,cls,age,tname,subject,tage) values(?,?,?,?,?,?)");
		pstmt.setString(1, name);
		pstmt.setString(2, cls);
		pstmt.setString(3, age);
		pstmt.setString(4, tname);
		pstmt.setString(5, subject);
		pstmt.setString(6, tage);
		
		int x = pstmt.executeUpdate();
		disp = arg0.getRequestDispatcher("Success.html");
		if(x>0) {
			
			arg0.setAttribute("status", "success");
			
		}else {
			
			arg0.setAttribute("status", "failed");
			
		}
		disp.forward(arg0, arg1);
		
		
	}
	catch (Exception e) {
		
		e.printStackTrace();
		
	}
	}

}
