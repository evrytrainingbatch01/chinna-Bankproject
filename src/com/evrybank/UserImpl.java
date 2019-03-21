package com.evrybank;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.evrybank.Customer;

public class UserImpl implements UserDao {

	public UserImpl() {

	}

	private String username;

	
     public void addCustomer(Customer cu) {

		/*final String DB_URL = "jdbc:mysql://localhost:3306/evrybankdb";
		final String USER = "evrybankuser";
		final String PASS = "evrybank123";

		PreparedStatement ps = null;
		Connection con = null;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("connection establish");

				String sql = "inset into customer values(?,?,?,?,?,)";
				ps = con.prepareStatement(sql);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("connection started...");

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public void show() {

		Scanner sc = new Scanner(System.in);
		System.out.println("welcone to EvryBank");
		System.out.println("Here choose details..");
	
		System.out.println("1.addCustomer\n");
		System.out.println("2.viewAllCustomer\n");
		System.out.println("3.updateCustomer\n");
		System.out.println("4.deleteCustomer\n");
		System.out.println("5.provideLoans\n");

		int num = sc.nextInt();
		switch (num) {
		case 1:
			createCustomer();
			
			System.out.println("usr  successfully added..");
			break;
		case 2:
			System.out.println("===========================");
			System.out.println("Here AllCustomer details");
			System.out.println("============================");
			viewAllCustomer();
			System.out.println("============================");
			break;
		case 3:
			System.out.println("Here delete Customers ");
			break;
		case 4:
			System.out.println("provide loans here");
			break;
		default:
			System.out.println("detalis here default..");
			break;
		}

	}

	public void viewAllCustomer() {
		
		final String DB_URL = "jdbc:mysql://localhost:3306/evrybankdb";
		final String USER = "evrybankuser";
		final String PASS = "evrybank123";

		PreparedStatement ps = null;
		Connection con = null;
		
		
		List<Customer> customers = new ArrayList<Customer>();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(DB_URL,USER,PASS);
			 ps = con.prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer1 = new Customer();
			    customer1.setFirstname(rs.getString("firstname"));
			    customer1.setLastname(rs.getString("Lastname"));
			    customer1.setCity(rs.getString("city"));
			    customer1.setLocation(rs.getString("location"));
				
				customers.add(customer1);
			}
			
			for(Customer customer : customers) {
				System.out.println(customer.getFirstname()+", "+customer.getLastname()+" ,"
			+customer.getCity()+","+customer.getLocation());
			}
			
			
			
		}
			catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	}

	public void createCustomer() {

		final String DB_URL = "jdbc:mysql://localhost:3306/evrybankdb";
		final String USER = "evrybankuser";
		final String PASS = "evrybank123";

		PreparedStatement ps = null;
		Connection con = null;
		
		int result=0;

		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("connection establish");

				String sql = "insert into customer (firstname,lastname,city,location) values(?,?,?,?)";
				ps = con.prepareStatement(sql);

				Customer cu = new Customer();
				Scanner sc=new Scanner(System.in);
				
				System.out.println("Enter fname:");
				String  fname=sc.next();
				System.out.println("Enter lastname:");
      			String lname=sc.next();
      			System.out.println("enter city");
				String city=sc.next();
				System.out.println("enter location");
     			String location=sc.next();
				

				
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, city);
				ps.setString(4, location);

			 result = ps.executeUpdate();
			 if(result>=0) {
				 System.out.println("inserted row");
			 }
			 else{
				 System.out.println("not inserted");
			 }

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		
	
}

	
}
