

public class Employee {
	
	private String firstName;
	private String lastName;
	private String department;
	private String position;
	private int salary;
	private int yearsOfService;
	private boolean lead;
	
	public Employee(String firstName, String lastName, String department, String position, int salary, int yearsOfService, boolean lead) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.department=department;
		this.position=position;
		this.salary=salary;
		this.yearsOfService=yearsOfService;
		this.lead=lead;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public boolean getLead() {
		return lead;
	}

	public void setLead(boolean lead) {
		this.lead = lead;
	}
	
	@Override
	public String toString() {
		return ("First Name: " + firstName + " " + "Last Name: " + lastName + " " + "Department: " + department + " " + "Position: " + position + " " + "Salary: " + salary + " " + "Years of Service: " + yearsOfService + " " + "Lead: " + lead + " ");
	}

}
