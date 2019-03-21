package evrybank.dao;

import java.util.Set;

import evrybank.model.Admin;
import evrybank.model.Customer;

public interface AdminDao {

	
		public Set<Admin> getAllAdmins();

		public Admin getAdmin(Integer id);
		
		public boolean deleteAdmin(Admin admin, Integer id);
		
		public boolean updateAdmin(Admin admin);
	
		public boolean addCustomer(Customer customer);
		
		public boolean addMoney(final int cid);
		
		public boolean aproveTransaction(int cid);
		
		public boolean provideLoans(int cid);
}
