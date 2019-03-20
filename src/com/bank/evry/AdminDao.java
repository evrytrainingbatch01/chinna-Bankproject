package com.bank.evry;

import java.sql.Statement;
import java.util.Set;

public interface AdminDao {

	   
	 Set<Admin> getAllAdmins(Statement statement);
	 
	
	
}
