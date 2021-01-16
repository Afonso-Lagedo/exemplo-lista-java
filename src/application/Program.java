package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import  entities.Employee;

public class Program {
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>(); 
		
		System.out.println("registration numbers employees:");
		int n = sc.nextInt();
				
		
		for(int i=0;i<n;i++) {
			System.out.println();
			sc.nextLine();//consumo de linha
			System.out.println("id:");
			Integer id = sc.nextInt();
			sc.nextLine();//consumo de linha
			System.out.println("name:");
			String name = sc.nextLine();
			System.out.println("salary:");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);					
		}
		
		System.out.println("Enter the employee id that will have salary increase:");
		int idSalary = sc.nextInt();
		Integer pos = position(list,idSalary);
		if (pos==null) {
			System.out.println("This ID does not exist!");
		}
		else {
			System.out.println("Enter the percentage");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		
		System.out.println("\nList of employees:");
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
				
		sc.close();
	}
	
	//função auxiliar para procurar id na lista
	
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i <list.size();i++) {
			if(list.get(i).getId()==id) {
				return i;
			}
		}
		return null;
	}
}