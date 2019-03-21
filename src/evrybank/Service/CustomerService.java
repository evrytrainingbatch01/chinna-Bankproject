package evrybank.Service;

import java.util.Set;

import evrybank.model.Account;
import evrybank.model.Customer;

public interface CustomerService {

     public Set<Customer> viewAllCustomer();
	
	public boolean addMoney(final int cid, final int amount );
	
	public boolean openAccount(Account account);
   
	public Customer getCustomer(Integer id);
	
	public boolean deleteCustomer(Customer customer, Integer id);
	
	public boolean updateCustomer(Customer customer);
	
}
