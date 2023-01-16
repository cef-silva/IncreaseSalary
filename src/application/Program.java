package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println();
		
		List<Employee> employees = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i+1));
			System.out.print("Id: ");
			sc.nextLine();
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee employee = new Employee(id, name, salary);
			
			employees.add(employee);
		}
		
		System.out.println();
		System.out.print("Enter the employee that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee employee = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null); 
		
		if (employee != null) {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employee.increaseSalary(percentage);
		}
		else {
			System.out.println("This id does not exist!");
		}
		
		System.out.println("List of employees:");
		
		for(Employee emp:employees) {
			System.out.println(emp);
		}
		
		sc.close();

	}

}
