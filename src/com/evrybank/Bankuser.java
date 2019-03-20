/*package com.evrybank;

import java.util.Scanner;

public class Bankuser {

	 private String account_no;
	 private String branchname;
	 private  long  balance;
	 private String  location;
	 
	 Scanner sc=new Scanner(System.in);
	 
	 void openAccount()
		{ 
			System.out.print("Enter Account No: ");
			account_no=sc.next();
			System.out.print("Enter BranchName: ");
			branchname=sc.next();
			System.out.print("Enter Balance: ");
			balance=sc.nextLong();
			System.out.print
		}

		//method to display account details
		void showAccount()
		{ 
			System.out.println(accno+","+name+","+balance);
		}

		//method to deposit money
		void deposit()
		{
			long amt;
			System.out.println("Enter Amount U Want to Deposit : ");
			amt=KB.nextLong();
			balance=balance+amt;
		}

		//method to withdraw money
		void withdrawal()
		{
			long amt;
			System.out.println("Enter Amount U Want to withdraw : ");
			amt=KB.nextLong();
			if(balance>=amt)
			{ 
				balance=balance-amt;
			}
			else
			{
				System.out.println("Less Balance..Transaction Failed..");
			}
		}

		//method to search an account number
		boolean search(String acn)
		{ 
			if(accno.equals(acn))
			{ 
				showAccount();
				return(true);
			}
			return(false);
		}
	 
}
*/