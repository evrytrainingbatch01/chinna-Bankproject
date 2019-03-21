package evrybank.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import evrybank.dao.AdminDao;
import evrybank.model.Admin;
import evrybank.model.Customer;
import evrybank.util.DatabaseUtil;

public class AdminDaoImpl implements AdminDao {
	
	
		Connection con = DatabaseUtil.getConnection();
		
			@Override
		   public boolean addCustomer(Customer customer) {
				PreparedStatement ps = null;
				 try {
				        ps = con.prepareStatement("INSERT INTO CUSTOMERDB(FIRSTNAME,LASTNAME,AGE,CITY,COUNTRY,PHONENUMBER,BALAMOUNT) VALUES (?, ?, ?, ?, ?, ?, ?)");
				        ps.setString(1, customer.getFirstname());
				        ps.setString(2, customer.getLastname());
				        ps.setInt(3, customer.getAge());
				        ps.setString(4, customer.getCity());
				        ps.setString(5, customer.getCountry());
				        ps.setInt(6, customer.getPhoneNumber());
				        ps.setInt(7, customer.getBalAmount());
				        int i = ps.executeUpdate();
				      if(i == 1) {
				    	  return true;
				      }
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				return false;
			}

			public Set<Admin> getAllAdmins() {

				Set<Admin> setAdmin = new HashSet<>();

				String sqlQueryString = "SELECT * FROM ADMIN";
				ResultSet rs = null;
				Statement statement = null;
				try {
					statement = con.createStatement();
					rs = statement.executeQuery(sqlQueryString);
					while (rs.next()) {
						Admin admin = new Admin();
						admin.setId(rs.getInt(1));
						admin.setFirstname(rs.getString(2));
						admin.setLastname(rs.getString(3));
						admin.setAge(rs.getInt(4));
						setAdmin.add(admin);
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} 

				return setAdmin;
			}

			public Admin getAdmin(Integer id) {
				ResultSet rs;
				Statement statement = null;
				try {
					statement = con.createStatement();
					rs = statement.executeQuery("SELECT * FROM ADMIN WHERE ID=" + id);
					if (rs.next()) {
						Admin admin = new Admin();
						admin.setId(rs.getInt(1));
						admin.setFirstname(rs.getString(2));
						admin.setLastname(rs.getString(3));
						admin.setAge(rs.getInt(4));

						return admin;
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				} 
				return null;
			}

			
			public boolean deleteAdmin(Admin admin, Integer id) {
				
				PreparedStatement ps = null;
				try {
					 ps = con.prepareStatement("DELETE FROM ADMIN WHERE ID = ?");
					ps.setInt(1, admin.getId());
					int i = ps.executeUpdate();
					if (i == 1) {
						return true;
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return false;
			}
			
			
		
				public boolean updateAdmin(Admin admin) {
					PreparedStatement ps = null;
					 try {
					        ps = con.prepareStatement("UPDATE ADMIN SET FIRSTNAME=?, LASTNAME=?, AGE=? WHERE ID=?");
					        ps.setString(1, admin.getFirstname());
					        ps.setString(2, admin.getLastname());
					        ps.setInt(3, admin.getAge());
					        ps.setInt(4, admin.getId());
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
				public boolean addMoney(int cid) {
					int result = 0;

					try {
						
						int pending_amount = getCustomerAmount(cid, con);
						int balAmount = getBalance(cid, con);
						PreparedStatement statement = con.prepareStatement("UPDATE customredb SET balAmount = ? WHERE id = ?");
						statement.setInt(1, balAmount + pending_amount);
						statement.setInt(2, cid);

						if(statement.executeUpdate() == 1) {
							
							PreparedStatement statement2 = con.prepareStatement("UPDATE transaction SET process_amount = 0 WHERE id = ?");
							statement2.setInt(1, cid);

							result = statement2.executeUpdate();
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
					return (result == 1) ? true : false;
				}
				private int getCustomerAmount(int cid, Connection con) {
					int sum = 0;
					try {
						PreparedStatement statement = con.prepareStatement("SELECT sum(process_amount) from transaction where id = ?");
						statement.setInt(1, cid);
						ResultSet resultSet = statement.executeQuery();
						if (resultSet.next()) {
							sum = resultSet.getInt(1);
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					return sum;
				}

				private int getBalance(int cid, Connection con) {
					
					int balance = 0;
					try {
						PreparedStatement statement = con.prepareStatement("SELECT balAmount from customerdb where id = ?");
						statement.setInt(1, cid);
						ResultSet resultSet = statement.executeQuery();
						if (resultSet.next()) {
							balance = resultSet.getInt("balance");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return balance;
				}


				

				@Override
				public boolean aproveTransaction(int cid) {
					
					int result = 0;

					try {
						
						int transfer_amount = getTransferAmount(cid, con);
						int balAmount = getBalance(cid, con);
						PreparedStatement statement =con.prepareStatement("UPDATE customer SET balAmount = ? WHERE id = ?");
						statement.setInt(1, balAmount + transfer_amount);
						statement.setInt(2, cid);
						int update = statement.executeUpdate();
						if( update >= 1) {
							
							PreparedStatement statement2 = con.prepareStatement("UPDATE transaction SET transfer_amount = 0 WHERE id = ?");
							statement2.setInt(1, cid);

							result = statement2.executeUpdate();
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
					return (result >= 1) ? true : false;
					
				}

				private int getTransferAmount(int cid, Connection con) {
					int sum = 0;
					try {
						PreparedStatement statement = con
								.prepareStatement("SELECT sum(transfer_amount) from transaction where id = ?");
						statement.setInt(1, cid);
						ResultSet resultSet = statement.executeQuery();
						if (resultSet.next()) {
							sum = resultSet.getInt(1);
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					return sum;
				}

				@Override
				public boolean provideLoans(int cid) {
					// TODO Auto-generated method stub
					return false;
				}

}
