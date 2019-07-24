package markSheetPkg;
import java.util.*;

public class MarksheetMain {

	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);
		MathOperation mathObj = new MathOperation();
		System.out.println("Please enter number of students");
		try{
			int noOfStudents = scannerObj.nextInt();
			int arr_of_grades[] = new int[noOfStudents];
			
			// collecting students grade in arr_of_grades
			for(int i=0; i<noOfStudents; ){
				System.out.println("Please enter grade of student[" + (i+1) + "] :");
				arr_of_grades[i] = scannerObj.nextInt();
				if(arr_of_grades[i] >= 0 && arr_of_grades[i] <= 100){
					i++;
				}else{
					System.out.println("Please enter students grade in range 1-100 !!");
				}
			}
			if(arr_of_grades.length == 0){
				System.out.println("Please Select at least one student");
				main(args);
			}
			
			int choice = 0;
			do{
				System.out.println("Please Enter your choice ");
				System.out.println("1.Average Of grades\n2.Maximum in grades\n3.Minimum in grades\n4.Passed students List\n5.exit");
				choice = scannerObj.nextInt();
				switch(choice){
				case 1:
					System.out.println("\tAverage of grades : " + mathObj.averageOfElements(arr_of_grades));
					break;
				case 2:
					System.out.println("\tmaximum of grades : " + mathObj.maximumOfElements(arr_of_grades));
					break;
				case 3:
					System.out.println("\tminimum of grades : " + mathObj.minimumOfElements(arr_of_grades));
					break;
				case 4:
					mathObj.eligibleOfElements(arr_of_grades);
					break;
				case 5:
					break;
					default:
						System.out.println("Invalid Choice !!");	
					
				}
			}while(choice!=5);	
			
		}catch(InputMismatchException e){
			System.out.println("Please enter only Integer value !! Try again \n");
			main(args);
		}
		

	}

}
