package pojoClass;

public class Employee {
	private String Name;
	private int Age;
	private String PhoneNo;
	private String Email;
	private String Address;
	private long RollNo;
	private String Designation;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getRollNo() {
		return RollNo;
	}
	public void setRollNo(long rollNo) {
		RollNo = rollNo;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	public String toString()
	{
	    String output = "Employee ID " + getRollNo() + "\nName: " + getName() + "\nAge : " + getAge() +
	        "\nPhone Number: " + getPhoneNo();

	    return output;
	}

}
