package evrybank.model;

public class Admin {

	
private Integer id;
private String firstname;
private String lastname;
private Integer age;

public Admin() {
	
	
}

public Admin(Integer id, String firstname, String lastname, Integer age) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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
}
