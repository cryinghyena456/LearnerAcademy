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
@WebServlet("/Student")
public class Student extends HttpServlet{
	
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/phase2";
	private String user = "root";
	private String pwd= "root";
	private int balance;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			
			
			String sql = "select * from db";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet res = pstmt.executeQuery();
			while (res.next())
				
				
			{ int id = res.getInt("id");
            String name = res.getString("name");
            int clas = res.getInt("class");
            System.out.println(clas);
				
			PrintWriter writer  = resp.getWriter();
			writer.println(id + " "+name+" "+clas);
			HttpSession session = req.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("class", clas);
			session.setAttribute("id", id);
			resp.sendRedirect("/LearnerPortal/Student.jsp");
			
			
			
			}
			
			
			
		}catch(Exception e) {
			
			
		}
		
		
	

	}}
