package com.learner;

import java.sql.DriverManager;
import java.sql.SQLException;



public class MyConnection {
private static String url = "jdbc:mysql://localhost:3306/phase2";
private static String user = "root";
private static String pass = "root";

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	DriverManager.getConnection(url,user,pass);
	
	System.out.println("connection done");
}
}
