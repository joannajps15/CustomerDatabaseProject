public class CustomerRecord {

	//Attributes
	private String firstName, lastName, addressOne, addressTwo, addressThree, telephone;
	private int age;
	private double income;
	
	//Constructor
	public CustomerRecord(String firstName, String lastName, String addressOne, String addressTwo, String addressThree, String telephone, int age, double income) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.addressThree = addressThree;
		this.telephone = telephone;
		this.age = age;
		this.income = income;
	}
	
	//Getter Methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddressOne() {
		return addressOne;
	}
	
	public String getAddressTwo() {
		return addressTwo;
	}
	
	public String getAddressThree() {
		return addressThree;
	}
	
	
	public String getTelephone() {
		return telephone;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getIncome() {
		return income;
	}
	
}
