package evrybank.Service.Impl;

import java.util.Set;

import evrybank.Service.AdminService;
import evrybank.dao.Impl.AdminDaoImpl;
import evrybank.model.Admin;
import evrybank.model.Customer;

public class AdminServiceImpl implements AdminService {

     AdminDaoImpl adminDao = new AdminDaoImpl();
	

	@Override
	public Set<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	@Override
	public Admin getAdmin(Integer id) {
		return adminDao.getAdmin(id);
	}
	
	public boolean deleteAdmin(Admin admin, Integer id) {
		return adminDao.deleteAdmin(admin, id);
	}
	
	public boolean updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}
	
	
	@Override
	public boolean addCustomer(Customer customer) {
		return adminDao.addCustomer(customer);
	}

	@Override
	public boolean addMoney(int cid) {
		
		return adminDao.addMoney(cid);
	}

	@Override
	public boolean aproveTransaction(int cid) {
		
		return adminDao.aproveTransaction(cid);
	}

	
}
