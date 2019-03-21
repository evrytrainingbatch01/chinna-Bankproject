package evrybank.dao;

import java.util.Set;

import evrybank.model.Account;
import evrybank.model.Admin;
import evrybank.model.Customer;

public interface CustomerDao {

public Set<Customer> viewAllCustomer();
	
	public boolean addMoney(final int cid, final int amount );
	
	public boolean openAccount(Account account);
	
	public Customer getCustomer(Integer id);
	
	public boolean deleteCustomer(Customer customer, Integer id);
	
	public boolean updateCustomer(Customer customer);
	
}
