package session5Pkg.employeePkg;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class for Operations on Employee in the list like add employee, sort employee list etc
 * @author Vinod
 * @date 04/08/2019
 */
public class Main {
	public static String view = "-------------------------------------------------------------------";
	public static void main(String[] args) {
		
		Scanner inputObj = new Scanner(System.in);
		ListOperation listObj = new ListOperation();
		
		/*listObj.addElement(new Employee("shubham",40000, 21));
		listObj.addElement(new Employee("suresh",30000, 21));
		listObj.addElement(new Employee("ramesh",40001, 21));
		listObj.addElement(new Employee("rohit",40001, 20));
		listObj.addElement(new Employee("vijay",40008, 21));
		*/
		
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Add an Employee\n2.Sort\n3.Display List\n4.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					int select = 0;
					System.out.println(view);
					do{
						try{
							inputObj.nextLine();
							System.out.println("Enter Employee Name :");
							String name = inputObj.nextLine();
							System.out.println("Enter Employee Salary :");
							double salary = inputObj.nextDouble();
							System.out.println("Enter Employee Age");
							int age = inputObj.nextInt();
							System.out.println(view);
							if(salary < 1){
								System.out.println("Salary should be positive !! Try again");
								select = 1;
							}else if(age < 1){
								System.out.println("Age should be positive integer !! Try Again");
								select = 1;
							}else{
								System.out.println("Employee " + name + " added in the list");
								listObj.addElement(new Employee(name, salary, age));
							}
							System.out.println(view);
							
						}catch(InputMismatchException exception){
							System.out.println(view);
							System.out.println("Warning : Entered Value Invalid !! Try Again");
							select = 1;
							System.out.println(view);
						}
					}while(select !=0);
					break;
				case 2:
					if(listObj.noOfElementInList() < 1){
						System.out.println(view + "\nList don't have employee !! please Add Employee First\n"+view);
					}else{
						listObj.head = listObj.mergeSort(listObj.head);
						System.out.println(view + "\nList Sorted \n" + view);
					}
					break;
				case 3:
					if(listObj.noOfElementInList() < 1){
						System.out.println(view + "\nList don't have employee !! please Add Employee First\n"+view);
					}else{
						listObj.DisplayList();
					}
					break;
				case 4:
					break;
					default:
						System.out.println(view + "\nInvalid Choice  !! Try Again\n" + view);
				}
				inputObj.nextLine();
			}catch(InputMismatchException exception){
				System.out.println(view + "\nWarning : Please Enter only Integer Value !! Try Again\n" + view);
				inputObj.nextLine();
			}
		}while(choice!=4);
	}

}