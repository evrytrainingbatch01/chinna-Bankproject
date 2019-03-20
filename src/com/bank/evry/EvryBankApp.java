package com.bank.evry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

public class EvryBankApp {

	public static void main(String []agr)
	
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the admin details");
		
		String adminuser=sc.next();
		
	
	final String DB_URL="jdbc:mysql://localhost:3306/evrybankdb";
	final String USER="evrybankuser";
	final String PASS="evrybank123";
	
	Statement stmt = null;
	Connection con = null;
	
	 
	try {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(DB_URL,USER,PASS);
			 System.out.println("connection establish");
			 stmt=con.createStatement();
			 
			 AdminDaoImpl admindao=new AdminDaoImpl();
			 
			 if(adminuser.equals("getAllAdmins")) {
			 
			Set<Admin> setofAdminone=admindao.getAllAdmins(stmt);
			System.out.println("data is coming sooon");
			 for(Admin user:setofAdminone) {
			     
				 System.out.println(user.getId()+""+user.getFirstname()+""+user.getLastname()+""+user.getAge());
			       }
			 }
						 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
		System.out.println("connection started...");
				
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
   

	
	}
}
