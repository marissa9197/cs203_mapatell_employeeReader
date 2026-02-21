

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		List<Employee> employees = loadEmployees("employeeData.txt");
		
		System.out.println("Lowest paid employee in each department: ");
		lowestPadiEmployees(employees);
		System.out.println("");
		System.out.println("Employees who've worked less than 4 years:");
		workLessThanFourYears(employees);
		System.out.println("");
		System.out.println("Average salary in the Marketing department:");
		averageSalaryMarketing(employees);
		System.out.println("");
		System.out.println("Employees with the longest tenure:");
		longestTenure(employees);
		System.out.println("");
		System.out.println("Number of leads in each department:");
		numberOfLeadsByDepartment(employees);
		
	}
		
		public static List<Employee> loadEmployees(String filename){
			List<Employee> employees = new ArrayList<>();
			
			try (BufferedReader b = new BufferedReader(new FileReader(filename))){
				b.readLine();
				String line;
				while ((line = b.readLine()) != null) {
					String [] data = line.split(",");
					if (data.length < 7)
						continue;
					
					String firstName = data[0].trim();
					String lastName = data[1].trim();
					String department = data[2].trim();
					String position = data[3].trim();
					int salary = Integer.parseInt(data[4].trim());
					int yearsOfService = Integer.parseInt(data[5].trim());
					boolean lead = data[6].trim().equalsIgnoreCase("Yes");
					
				employees.add(new Employee(firstName, lastName, department, position, salary, yearsOfService, lead));
				}
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
			}
			return employees;
		}
		
		//lowest paid employee
		public static void lowestPadiEmployees(List<Employee> employees) {
			List<String> departments = new ArrayList<>();
			
			for (Employee e : employees) {
				if (!departments.contains(e.getDepartment())) {
					departments.add(e.getDepartment());
				}
			}
			for (String department : departments) {
				Employee lowest = null;
				
				for (Employee e : employees) {
					if (e.getDepartment().equals(department)) {
						if (lowest == null || e.getSalary()<lowest.getSalary()) {
							lowest = e;
						}
					}
				}
				if (lowest != null) {
					System.out.println(department + ": " + lowest.getFirstName() + " " + lowest.getLastName() + " - $" + lowest.getSalary());
				}
			}
		}
		
		//been with company less than 4 years
		public static void workLessThanFourYears(List<Employee> employees) {
			for (Employee e : employees) {
				if (e.getYearsOfService() < 4) {
					System.out.println("Full Name: " + e.getFirstName() + " " + e.getLastName() + " , " + "Department: " + e.getDepartment() + " , " + "Position: " + e.getPosition() + " , " + "Salary: " + e.getSalary() + " , " + "Years of Service: " + e.getYearsOfService() + " , " + "Lead: " + e.getLead());
				}
			}
		}
		
		//average salary marketing
		public static void averageSalaryMarketing(List<Employee> employees) {
			double total = 0;
			int count = 0;
			
			for (Employee e : employees) {
				if(e.getDepartment().equalsIgnoreCase("Marketing")) {
					total = total + e.getSalary();
					count++;
				}
			}
			double avg = total / count;
			System.out.println( avg);
			}
		
		//longest tenure
		public static void longestTenure(List<Employee> employees) {
			int maxYears = 0;
			
			for (Employee e : employees) {
				if (e.getYearsOfService() > maxYears) {
					maxYears = e.getYearsOfService();
				}
			}
			for (Employee e : employees) {
				if (e.getYearsOfService() == maxYears) {
					System.out.println("Full Name: " + e.getFirstName() + " " + e.getLastName() + " , " + "Department: " + e.getDepartment() + " , " + "Position: " + e.getPosition() + " , " + "Salary: " + e.getSalary() + " , " + "Years of Service: " + e.getYearsOfService() + " , " + "Lead: " + e.getLead());
				}
			}
		}
		
		//departments and number of leads
		public static void numberOfLeadsByDepartment(List<Employee> employees) {
			List<String> departments = new ArrayList<>();
			
			for (Employee e : employees) {
				if (!departments.contains(e.getDepartment())) {
					departments.add(e.getDepartment());
				}
			}
			for (String department : departments) {
				int leadCount = 0;
				
				for (Employee e : employees) {
					if (e.getDepartment().equals(department) && e.getLead()) {
						leadCount++;
					}
				}
				System.out.println(department + ": " + leadCount + " " + "leads");
			}
		}
		
		
		
		
		}


		
		
		

	
