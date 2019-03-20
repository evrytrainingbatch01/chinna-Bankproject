package com.evrybank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserImpl implements UserDao {
	
	public UserImpl() {
		
	}
	private String username;

	@Override
	public void addCustomer(Customer cu) {
		
		final String DB_URL="jdbc:mysql://localhost:3306/evrybankdb";
		final String USER="evrybankuser";
		final String PASS="evrybank123";
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(DB_URL,USER,PASS);
				 System.out.println("connection establish");
				 
				 String sql="inset into customer values(?,?,?,?,?,)";
				 ps=con.prepareStatement(sql);
				
				
							 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     
			System.out.println("connection started...");
					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	   
		 
		
		
	}

	@Override
	public void show() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Admin username:"+username);
	System.out.println("Here choose details..");
		System.out.println("1.addCustomer");
		System.out.println("2.updateCustomer");
		System.out.println("3.deleteCustomer");
		System.out.println("4.provideLoans");
		
			
			
			int  num=sc.nextInt();
			switch(num)
			{
			case 1:
				 createCustomer();
				 System.out.println("ENter firstname:");
				 String str=sc.next();
				 System.out.println("ENter lastname:");
				 String str1=sc.next();
				 System.out.println("ENter city:");
				 String str2=sc.next();
				 System.out.println("ENter locationm:");
				 String str3=sc.next();
				 System.out.println("usr  successfully added..");
				 break;
			case 2:
				System.out.println("here update details");
				break;
			case 3:
				System.out.println("delete customer details");
				break;
			case 4:
				System.out.println("provide loans here");
				break;
			default :
			System.out.println("detalis here default..");
			break;
			}
			
	}

	public void createCustomer() {
		
		final String DB_URL="jdbc:mysql://localhost:3306/evrybankdb";
		final String USER="evrybankuser";
		final String PASS="evrybank123";
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(DB_URL,USER,PASS);
				 System.out.println("connection establish");
				 
				 String sql="inset into customer values(?,?,?,?,)";
				 ps=con.prepareStatement(sql);
				Customer cu=new Customer();
				ps.setString(1,cu.getFirstname());
				ps.setString(2, cu.getLastname());
				ps.setString(3, cu.getCity());
				ps.setString(4, cu.getLocation());
				
				int i=ps.executeUpdate();
				if(i==0)
				{
					System.out.println("one row record.."+i);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     
		
					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	   
		 
		
	}
}
