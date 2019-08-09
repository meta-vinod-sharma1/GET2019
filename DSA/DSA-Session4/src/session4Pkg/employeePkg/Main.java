package session4Pkg.employeePkg;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is main class for Operations on Employee Class 
 * @author Vinod
 * @date 03/08/2019
 */
public class Main {
	public static String view = "-------------------------------------------------------------------";
	public static void main(String[] args) {
		
		Scanner inputObj = new Scanner(System.in);
		EmployeeCollectionClass e=new EmployeeCollectionClass();
		
		HashSet<Integer> empIdCollection= new HashSet<Integer> ();	
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Add an Employee\n2.Sorted By Id and Display\n3.Sorted By Name and Display\n4.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					System.out.println(view);
					int select = 0;
					do{
						select = 0;
						try{
							System.out.println("Enter Employee Id :");
							int id = inputObj.nextInt();
							System.out.println("Enter Employee Name :");
							inputObj.nextLine();
							String name = inputObj.nextLine();
							System.out.println("Enter Employee Address");
							String address = inputObj.nextLine();
							if(id <1){
								System.out.println( view +"\nId can't be less than 1  !! Try again\n" + view);
								select = 1;
							}else{
								if(empIdCollection.add(id)){
									e.addEmployee(new Employee(id,name,address));
								}else{	
									System.out.println( view + "\nEmployee with This id Already Exist !! Try Again\n" + view);
									select =1;
								}
							}
						}catch(InputMismatchException exception){
							System.out.println(view);
							System.out.println("Warning : Entered Value Invalid !! Try Again");
							System.out.println(view);
							inputObj.nextLine();
							select =1;
						}
					}while(select !=0);
					break;
				case 2:
					if(e.empCollection.isEmpty()){
						System.out.println(view + "\nNo employee in Collection\n" + view);
					}else{
						e.sortedById();
					}
					break;
				case 3:
					if(e.empCollection.isEmpty()){
						System.out.println(view + "\nNo employee in Collection\n" + view);
					}else{
						e.sortedByName();
					}
				
					break;
				case 4:
					break;
					default:
						System.out.println("Invalid Choice  !! Try Again");
				}	
			}catch(InputMismatchException exception){
				System.out.println(view);
				System.out.println("Warning : Please Enter only Integer Value !! Try Again");
				System.out.println(view);
				inputObj.nextLine();
			}
		}while(choice!=4);
	}

}