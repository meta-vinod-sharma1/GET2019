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
				if(arr_of_grades[i] >= 0 && arr_of_grades[i] <= 0){
					i++;
				}else{
					System.out.println("Please enter students grade in range 1-100 !!");
				}
				
			}
			
			try{ // check arithmetic exception
				if(arr_of_grades.length == 0){
					System.out.println("Please Select at least one student");
					main(args);
				}else{
					System.out.println("\t\t\tResults\n\n");
					System.out.println("\tAverage of grades : " + mathObj.averageOfElements(arr_of_grades));
					System.out.println("\tmaximum of grades : " + mathObj.maximumOfElements(arr_of_grades));
					System.out.println("\tminimum of grades : " + mathObj.minimumOfElements(arr_of_grades));
					mathObj.eligibleOfElements(arr_of_grades);
				}
			}catch(ArithmeticException e){
				System.out.println("Opps\nException : " + e);
			}
			
			
			
		}catch(InputMismatchException e){
			System.out.println("Please enter only Integer value !! Try again \n");
			main(args);
		}
		

	}

}
