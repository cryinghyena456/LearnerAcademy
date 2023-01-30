package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Teacher")
public class InputT extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
			PreparedStatement pstmt = con.prepareStatement("select * from db");
			
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()==true) {
				
				String tname = set.getString("tname");
				String subject = set.getString("subject");
				String tage = set.getString("tage");
				
				System.out.println(tname);
				System.out.println(subject);
				System.out.println(tage);
				
				
				PrintWriter writer = arg1.getWriter();
				writer.println(tname +" "+subject+" "+tage);
				
			}
		}catch(Exception e) {
			
		}
	}
	}
	
	

