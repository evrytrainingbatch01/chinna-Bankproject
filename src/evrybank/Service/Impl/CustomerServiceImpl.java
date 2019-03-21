package evrybank.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import evrybank.Service.CustomerService;
import evrybank.dao.Impl.CustomerDaoImpl;
import evrybank.model.Account;
import evrybank.model.Customer;
import evrybank.util.DatabaseUtil;

public class CustomerServiceImpl implements CustomerService {

	Connection con = DatabaseUtil.getConnection();
	
	  CustomerDaoImpl customerdao=new CustomerDaoImpl();

	@Override
	public Set<Customer> viewAllCustomer() {
		// TODO Auto-generated method stub
		return customerdao.viewAllCustomer();
	}

	@Override
	public boolean addMoney(int cid, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openAccount(Account account) {
		return customerdao.openAccount(account);
		
	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerdao.getCustomer(id);
	}

	@Override
	public boolean deleteCustomer(Customer customer, Integer id) {
		// TODO Auto-generated method stub
		return customerdao.deleteCustomer(customer, id);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerdao.updateCustomer(customer);
	}

}
