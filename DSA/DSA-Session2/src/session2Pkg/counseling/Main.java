package session2Pkg.counseling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import jxl.read.biff.BiffException;

/**
 * 
 * @author Vinod
 * @date 01/07/2019
 */
public class Main {
	public static void main(String[] args){
		Scanner inputObj = new Scanner(System.in);
		ReadExcel readObj = new ReadExcel();

		// Reading xls files 
		try {
			readObj.readStudents("StudentList.xls");
			readObj.readProgram("ProgramList.xls");

		} catch (BiffException | IOException e) {

			System.out.println("File not Found");
		}

		//Counselling of Students by Allocation method
		Counseling counselingObj = new Counseling();
		ArrayList<AllocateProgram> allocatingList = counselingObj.allocationProgram(ReadExcel.studentList, ReadExcel.programList);
		
		//Writing Excel of allocating students 
		ExcelWrite.writeFile(allocatingList);

		//Printing Allocating List
		System.out.println("-------------------------------------------------------------------------------");
		for(int i=0; i< allocatingList.size(); i++){
			System.out.println("Student Name : " + allocatingList.get(i).name + " Branch : " + allocatingList.get(i).branch);
		}
		System.out.println("-------------------------------------------------------------------------------");

	}

}
