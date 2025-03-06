package com.rakesh;

import java.util.Scanner;

import com.rakesh.crudwithhibernate.controller.EmployeeController;
import com.rakesh.crudwithhibernate.util.SessionFactoryUtil;

public class App 
{
    public static void main( String[] args )
    {

		EmployeeController employeeController = new EmployeeController();
		
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Employees Registry App.");
		
		while(flag) {
			
			System.out.printf("%n ");
			System.out.println("Choose the option below");
			System.out.println("1. show employees");
			System.out.println("2. get employee by id");
			System.out.println("3. create new employee");
			System.out.println("4. update an existing employee");
			System.out.println("5. delete an employee");
			System.out.println("6. exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:{
				employeeController.findAll();
				break;
			}
			
			
			case 2:{
				System.out.println("Enter employee Id");
				int id = sc.nextInt();
				
				employeeController.findById(id);
				
				break;
			}
			
			case 3:{
				System.out.println("Enter Employee name");
				String name = sc.next();
				System.out.println("Enter Employee department");
				String department = sc.next();
				System.out.println("Enter Enployee salary");
				String salary = sc.next();
				
				employeeController.save(name, department, salary);
				
				break;
			}
			
			case 4:{
				System.out.println("Enter the id of the employee to be updated");
				int id = sc.nextInt();
				System.out.println("Enter the name to update");
				String name = sc.next();
				System.out.println("Enter the department to update");
				String department = sc.next();
				System.out.println("Enter the salary to update");
				String salary = sc.next();
				
				employeeController.update(id, name, department, salary);
				
				break;
			}
			case 5:{
				System.out.println("Enter the id of the employee to be deleted");
				int id = sc.nextInt();
				
				employeeController.delete(id);
				
				break;
			}
			case 6:{
				System.out.println("Bye!");
				SessionFactoryUtil.closeSessionFactory(SessionFactoryUtil.getSessionFactory());
				flag = false;
                sc.close();
			}
			}
			
		}
    }
}
