package session2Pkg.counseling;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/**
 * This class used to read xls files of student and program from the given path and create student list and program list
 * @author Vinod
 *
 */
public class ReadExcel {
	
	Workbook workbook = null;
	public static Queue<Student> studentList = new LinkedList<>();
	public static Map<String,Integer> programList =  new HashMap< String,Integer>();
	
	/**
	 * This method used to read student name and their preferences and add them into studentlist Queue 
	 * @param filePath given file path
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readStudents(String filePath) throws BiffException, IOException{
		
		workbook = Workbook.getWorkbook(new File(filePath));
		
		Sheet sheet = workbook.getSheet(0);
		//Rows of sheet
		for(int index =0 ; index< sheet.getRows(); index++){
			Cell cell;
			ArrayList<String> parameterList = new ArrayList<String>();
			//column of sheet
			for(int index2=1; index2 < sheet.getColumns(); index2++){
				cell = sheet.getCell(index2, index);
				parameterList.add(cell.getContents());
			}
			cell = sheet.getCell(0, index);
			Student studentObj = new Student(cell.getContents(),parameterList);
			studentList.add(studentObj);
		}	
	}
	
	/**
	 * This method used to read program xls by given path
	 * @param filePath file path
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readProgram( String filePath) throws BiffException, IOException{
		workbook = Workbook.getWorkbook(new File(filePath));
		
		Sheet sheet = workbook.getSheet(0);
		for(int index =0 ; index< sheet.getRows(); index++){
				Cell cell1 = sheet.getCell(0 ,index);
				Cell cell2 = sheet.getCell(1 ,index);
				programList.put(cell1.getContents(),Integer.parseInt(cell2.getContents()));
		}	
	}
}
