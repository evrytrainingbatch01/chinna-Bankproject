package evrybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import evrybank.dao.CustomerDao;
import evrybank.model.Account;
import evrybank.model.Admin;
import evrybank.model.Customer;
import evrybank.util.DatabaseUtil;

public class CustomerDaoImpl implements CustomerDao {
  
	Connection con = DatabaseUtil.getConnection();
	
	@Override
	public Set<Customer> viewAllCustomer() {
		Set<Customer> setcustomer = new HashSet<>();

		String sqlQueryString = "SELECT * FROM CUSTOMERDB";
		ResultSet rs = null;
		Statement statement = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sqlQueryString);
			while (rs.next()) {
				Customer cu=new Customer();
			     
				cu.setFirstname(rs.getString(1));
				cu.setLastname(rs.getString(2));
				cu.setAge(rs.getInt(3));
				cu.setCity(rs.getString(4));
				cu.setCountry(rs.getString(5));
				cu.setPhoneNumber(rs.getInt(6));
				cu.setBalAmount(rs.getInt(7));
				
				
				setcustomer.add(cu);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return setcustomer;
	}

	@Override
	public boolean addMoney(int cid, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openAccount(Account account) {
		
		PreparedStatement ps = null;
		 try {
		        ps = con.prepareStatement("INSERT INTO ACCOUNT VALUES (?, ?, ?, ?,?,?)");
		        ps.setInt(1, account.getAid());
		        ps.setString(2,account.getBankName());
		        ps.setInt(3, account.getAccountNumber());
		        ps.setString(4, account.getAccountType());
		        ps.setString(5, account.getBranchName());
		        ps.setInt(6, account.getDepositAmount());
		        
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    	  return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
		
	}

	@Override
	public Customer getCustomer(Integer id) {
		ResultSet rs;
		Statement st = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM CUSTOMERDB WHERE ID=" + id);
			if (rs.next()) {
				Customer cu=new Customer();
				cu.setFirstname(rs.getString(1));
               cu.setLastname(rs.getString(2));
               cu.setAge(rs.getInt(3));
               cu.setCity(rs.getString(4));
               cu.setCountry(rs.getString(5));
               cu.setPhoneNumber(rs.getInt(6));
               cu.setBalAmount(rs.getInt(7));
				return cu;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean deleteCustomer(Customer customer, Integer id) {
		PreparedStatement ps = null;
		try {
			 ps = con.prepareStatement("DELETE FROM CUSTOMERDB WHERE ID = ?");
			ps.setInt(1, customer.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		PreparedStatement ps = null;
		 try {
		        ps = con.prepareStatement("UPDATE CUSTOMERDB SET FIRSTNAME=?, LASTNAME=?, AGE=?,CITY=?,COUNTRY=? PHONENUMBER=?,BALAMOUNT=? WHERE ID=?");
		       ps.setString(1, customer.getFirstname());
		       ps.setString(2, customer.getLastname());
		       ps.setInt(3, customer.getAge());
		       ps.setString(4, customer.getCity());
		       ps.setString(5, customer.getCountry());
		       ps.setInt(6, customer.getPhoneNumber());
		       ps.setInt(7,customer.getBalAmount());
		       ps.setInt(8,customer.getId());
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    	  return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}

	
	
}
