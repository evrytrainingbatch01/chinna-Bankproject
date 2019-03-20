package com.bank.evry;

import java.sql.Statement;
import java.util.Set;

public class AdminDaoImpl implements AdminDao {

	  BankDao dao=new BankDao();
	  
	  
	   
	@Override
	public Set<Admin> getAllAdmins(Statement stmt) {
	
	return dao.getAllAdmins(stmt);
	}

	
}
