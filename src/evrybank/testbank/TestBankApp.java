package evrybank.testbank;

import java.util.Scanner;
import java.util.Set;

import evrybank.Service.Impl.AdminServiceImpl;
import evrybank.Service.Impl.CustomerServiceImpl;
import evrybank.model.Account;
import evrybank.model.Admin;
import evrybank.model.Customer;

public class TestBankApp {

	public static void main(String[] args)
	{
		
		System.out.println("@@@@@-WELCOME TO EVRYBANK-@@@@@");
		Scanner sc = new Scanner(System.in);
		
		String username;
		String password;
		
		System.out.println("username:");
		username=sc.next();
		System.out.println("password:");
		password=sc.next();
		if(username.equals("chinna")&&password.equals("12345")) {
			System.out.println("your logged in");
			
		}
		

		AdminServiceImpl adminService=new AdminServiceImpl();
		
		CustomerServiceImpl customerService=new CustomerServiceImpl();
		
		
			int choice;
		do {
			
		
		System.out.println("choose Your Choice");
		System.out.println("1.AddCustomer");
		System.out.println("2.AllAdmins");
		System.out.println("3.getAdmin");
		System.out.println("4.updateAdmin");
		System.out.println("5.deleteAdmin");
		System.out.println("6.viewAllCustomer");
		System.out.println("7.openAccount");
		System.out.println("8.updateCustomer");
		System.out.println("9.AddMoney");
		System.out.println("10.ApproveTransaction-Admin");
		 choice = sc.nextInt();
		
		switch (choice) {
		
		case 1: addCustomer(sc, choice, adminService);
		    break;
		case 2: getAllAdmins(sc, choice, adminService);
		         break;
		case 3: getAdmin(sc, choice, adminService);
		             break;
		case 4: updateAdmin(sc, choice, adminService);
		           break;
		case 5: deleteAdmin(sc, choice, adminService);
		      break;
		case 6: viewAllCustomers(sc,choice,customerService);
		        break;
		case 7:openAccount(sc,choice,customerService);
		      break;
		case 8: updateCustomer(sc,choice,customerService);
		       break;
		case 9:addMoney(sc,choice,adminService); 
		      break;
		case 10:approveTransactions(sc,choice,adminService);
		      break;
		default:
				break;
		}
		}
		while(choice!=5);
		}

	private static void approveTransactions(Scanner sc, Integer choice, AdminServiceImpl adminService) {
		if(choice.equals(10))
		{
			System.out.println("Please enter customer id");
			int cid = sc.nextInt();
			if (adminService.aproveTransaction(cid)) {
				System.out.println("Money transfored");
			} else {
				System.out.println("Transaction faild");
			}
		}
		
	}

	private static void addMoney(Scanner sc, Integer choice, AdminServiceImpl adminService) {
     if(choice.equals(9))
     {
		System.out.println("Please enter customer id");
		int id = sc.nextInt();
		if (adminService.addMoney(id)) {
			System.out.println("Money transfored to customer account");
		} else {
			System.out.println("Money not transfored to the customer account");
		}
		
     }	
	}

	private static void updateCustomer(Scanner sc, Integer choice, CustomerServiceImpl customerService) {
		
		if (choice.equals(8)) {
			boolean updatecustomer = false;
			System.out.println("here update customer details");
			updatecustomer = sc.nextBoolean();
			if (updatecustomer== true) {
				System.out.println("here provide which id you want to updated : ");
				Integer index = sc.nextInt();

				Customer customeruser =  customerService.getCustomer(index);
				System.out.println("What you want to update from the below options ?");
				System.out.println("1.  Firstname 2.  Lastname 3.  Age 4.CITY 5.COUNTRY 6.PHONENUMBER 7.BALAMOUNT");
				int number = sc.nextInt();
				switch (number) {

				case 1:
					System.out.println("Update Firstname selected");
					
					customeruser.setFirstname(sc.next());
					System.out.println("Firstname Updated");
					break;

				case 2:
					System.out.println("Update Lastname selected");
					
					customeruser.setLastname(sc.next());
					System.out.println("Lastname Updated");
					break;

				case 3:
					System.out.println("Update Age selected");
					
					customeruser.setAge(sc.nextInt());
					System.out.println("Age Updated");
					break;
				case 4:
					System.out.println("Update City selected");
					customeruser.setCity(sc.next());
					break;
				case 5:
					System.out.println("Update Country selected");
					customeruser.setCountry(sc.next());
					break;
				case 6:
					System.out.println("Update  Phonenumber selected");
					customeruser.setPhoneNumber(sc.nextInt());
					break;
				case 7:
					System.out.println("Update balAmount selected");
					customeruser.setBalAmount(sc.nextInt());
					break;
				case 0:
					System.out.println("Select an option");
					break;
				}

				boolean isUpdated = customerService.updateCustomer(customeruser);
				if (isUpdated) {
					System.out.println("Customer is Updated");
				}
			}
		}
		
	}

	private static void openAccount(Scanner sc, Integer choice, CustomerServiceImpl customerService) {
		
           if (choice.equals(7))
            {
			
			Account account=new Account();
			System.out.println("#############################");
			System.out.println("Enter Account details here..!");
			System.out.println("#################################");
			System.out.println("Enter account id");
			account.setAid(sc.nextInt());
			System.out.println("Enter bank name :");
			account.setBankName(sc.next());
			System.out.println("Enter AccountNumber :");
			account.setAccountNumber(sc.nextInt());
			System.out.println("Enter AccountType:");
			account.setAccountType(sc.next());
			System.out.println("Enter branch name:");
			account.setBranchName(sc.next());
			
			System.out.println("Minmum deposit amount-500 true / false");
			boolean depositamount = sc.nextBoolean();
			if(depositamount){
				System.out.println("add deposit amount here");
				account.setDepositAmount(sc.nextInt());
			}
			
			
			boolean accountopen = customerService.openAccount(account);
			if (accountopen) {
				System.out.println("Account Created Successfully");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
		}
		
	}

	public static void viewAllCustomers(Scanner sc, Integer choice, CustomerServiceImpl customerService) {
				
		if (choice.equals(6)) {
			Set<Customer> setCustomer = customerService.viewAllCustomer();
			System.out.println("************************");
			System.out.println("ALL Customer Details: ");
			System.out.println("*************************");
			for (Customer customer : setCustomer) {
				
				System.out.println(customer.getId()+" ,"+customer.getFirstname()+" ,"
			+customer.getLastname()+" ,"+customer.getAge()+","+customer.getCity()+","+customer.getPhoneNumber()+","+customer.getBalAmount());
				System.out.println("***************************");
			}
		}
	}

	public static void getAllAdmins(Scanner sc, Integer choice, AdminServiceImpl adminService) {
		
		if (choice.equals(2)) {
			Set<Admin> setAdmins = adminService.getAllAdmins();
			System.out.println("************************");
			System.out.println("admin details are : ");
			System.out.println("*************************");
			for (Admin service : setAdmins) {
				
				System.out.println(service.getId() + " ," + service.getFirstname() + " ," + service.getLastname()
						+ " ," + service.getAge());
				System.out.println("***************************");
			}
		}
	}

	public static void getAdmin(Scanner sc, Integer choice, AdminServiceImpl adminService) {
		
		if (choice.equals(3)) {
			System.out.println("here provide the particular admin Id : ");
			Integer index = sc.nextInt();
			Admin service = adminService.getAdmin(index);
		
			System.out.println("=========================");
			System.out.println("Admin details : ");
			System.out.println("===========================");
			System.out.println(service.getId() + ", " + service.getFirstname() + "," + service.getLastname()
					+ "," + service.getAge());
			System.out.println("=============================");
		}
	}

	public static void deleteAdmin(Scanner sc, Integer choice, AdminServiceImpl adminService) {
		
		if (choice.equals(5)) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("choose you want delete admin id : ");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			Integer index = sc.nextInt();
			Admin adminUser = adminService.getAdmin(index);
			// now call the delete method
			boolean isDeleted = adminService.deleteAdmin(adminUser, index);
			if (isDeleted) {
				System.out.println("Admin user deleted");
			}
		}
	}

	public static void updateAdmin(Scanner sc, Integer choice, AdminServiceImpl adminService) {
	
		if (choice.equals(4)) {
			boolean adminupdate = false;
			System.out.println("you want to update amdin details:");
			adminupdate = sc.nextBoolean();
			if (adminupdate == true) {
				System.out.println("Please provide id of user to be updated : ");
				Integer index = sc.nextInt();

				Admin adminUser =  adminService.getAdmin(index);
				System.out.println("What you want to update from the below options ?");
				System.out.println("1. Update Firstname 2. Update Lastname 3. Update Age");
				int number = sc.nextInt();
				switch (number) {

				case 1:
					System.out.println("Update Firstname selected");
					
					adminUser.setFirstname(sc.next());
					System.out.println("Firstname Updated");
					break;

				case 2:
					System.out.println("Update Lastname selected");
					
					adminUser.setLastname(sc.next());
					System.out.println("Lastname Updated");
					break;

				case 3:
					System.out.println("Update Age selected");
					
					adminUser.setAge(sc.nextInt());
					System.out.println("Age Updated");
					break;

				case 0:
					System.out.println("Select an option");
					break;
				}

				boolean isUpdated = adminService.updateAdmin(adminUser);
				if (isUpdated) {
					System.out.println("Admin User Updated");
				}
			}
		}
	}
	
	
	public static void addCustomer(Scanner sc, Integer choice,AdminServiceImpl adminService ) {
		
		if (choice.equals(1)) {
			
			Customer newCustomer = new Customer();
			System.out.println("#############################");
			System.out.println("Enter customer details here..!");
			System.out.println("#################################");
			System.out.println("Enter Customer Firstname :");
			newCustomer.setFirstname(sc.next());
			System.out.println("Enter customer lastname   :");
			newCustomer.setLastname(sc.next());
			System.out.println("Enter customer age :");
			newCustomer.setAge(sc.nextInt());
			System.out.println("Enter customer city:");
			newCustomer.setCity(sc.next());
			System.out.println("Enter the customer country:");
			newCustomer.setCountry(sc.next());
			System.out.println("Contact number :");
			newCustomer.setPhoneNumber(sc.nextInt());
			
			System.out.println("customer want to add balance here true / false");
			boolean ifAddAmount = sc.nextBoolean();
			if(ifAddAmount){
				System.out.println("how much amount you want add");
				newCustomer.setBalAmount(sc.nextInt());
			}
			
			boolean customeradd = adminService.addCustomer(newCustomer);
			if (customeradd) {
				System.out.println("New Customer Created Successfully");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			}
		}
		
		
		
	}
	}


