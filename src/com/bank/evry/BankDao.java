package com.bank.evry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class BankDao {

	
	public Set<Admin> getAllAdmins(Statement stmt)
	{
		Set<Admin> setofAdmins=new HashSet<>();
		
		String sql="select *from admin";
		
		ResultSet rs=null;
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Admin admin=new Admin();
				
				admin.setId(rs.getInt(1));
				admin.setFirstname(rs.getString(2));
				admin.setLastname(rs.getString(3));
				admin.setAge(rs.getInt(4));
				
				setofAdmins.add(admin);
				
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return setofAdmins;
		
	}
}
