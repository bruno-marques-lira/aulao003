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
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registred? ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println("");
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while(hasId(list, id)) {
				System.out.println("Id alredy taken! Try again: ");
				id = sc.nextInt();
			}	
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		
		// Lambda expression
		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Emter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees: ");
		for(Employee e : list) {
			System.out.println(e);
		}
		
		//Integer pos = position(list, idsalary);
		//if(pos == null) {
		//	System.out.println("This id does not exist!");
		//}
		//else {
		//	System.out.print("Emter the percentage: ");
		//	double percent = sc.nextDouble();
		//	list.get(pos).increaseSalary(percent);
		//}
		
		//System.out.println();
		//System.out.println("List of employees: ");
		//for(Employee emp : list) {
		//	System.out.println(emp);
		//}
		

		//if(emp == null) {
		//	System.out.println("This id does not exist!");
		//}
		//else {
		//	System.out.println("Enter the percentage: ");
		//	Double percentage = sc.nextDouble();
		//}
		
		//System.out.println();
		//System.out.println();
		//sc.close();
		sc.close();
	}
	
	public static Integer position(List<Employee> list, int id) {
		
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		// Express�o Lambda
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
