package au.com.example.mvc.model.customer;

public class Customer {

    private Long id;
	private String first_name;
	private String last_name;
	
	public Customer(Long id, String first_name, String last_name) {
        this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
