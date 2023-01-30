package com.learner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Fetch")
public class FetchData extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2","root","root");
			PreparedStatement pstmt = con.prepareStatement("select * from db");
			
			ResultSet set = pstmt.executeQuery();
			
			while(set.next()==true) {
				
				String name = set.getString("name");
				String cls = set.getString("cls");
				String age = set.getString("age");
				
				System.out.println(name);
				System.out.println(cls);
				System.out.println(age);
				
				
				PrintWriter writer = arg1.getWriter();
				writer.println(name +" "+cls+" "+age);
				
			}
		}catch(Exception e) {
			
		}
	}
		
		
		
	
}
