package com.bank.evry;

public class Customer {

	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private int mobile;
	private String emailid;
	
	public Customer()
	{
		
	}

	public Customer(String firstname, String lastname, int age, int mobile, String emailid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.mobile = mobile;
		this.emailid = emailid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	
	
}
