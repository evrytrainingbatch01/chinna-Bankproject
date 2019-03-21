package evrybank.model;

public class Customer {

	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String city;
	private String country;
	private Integer phoneNumber;
	private Integer balAmount;
	
	public Customer(){
		
	}
	
	public Customer(String firstname, String lastname, Integer age, String city, String country,
			Integer phoneNumber, Integer balAmount) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.balAmount = balAmount;
	}

	public Integer getId() {
		return id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getBalAmount() {
		return balAmount;
	}

	public void setBalAmount(Integer balAmount) {
		this.balAmount = balAmount;
	}


}
