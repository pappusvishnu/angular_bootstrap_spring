package au.com.angular.js.mvc.model.customer;

public class Customer {

	private String full_name;
	private String first_name;
	private String last_name;
	
	public Customer(String full_name, String first_name, String last_name) {
		this.full_name = full_name;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public String getFullName() {
		return full_name;
	}
	
	public void setFullName(String full_name) {
		this.full_name = full_name;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
}
