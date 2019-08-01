package session2Pkg.counseling;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to create excel file of student with their allocated Program.
 * @author Vinod
 */
public class ExcelWrite {

	/**
	 * This method is used to put all student data in excel file.
	 */
	public static void writeFile(ArrayList<AllocateProgram> list) {
		int index = 0;

		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\Vinod\\Documents\\AllocateStudentList.xls"));
			WritableSheet workbookSheet = workbook.createSheet("sheet1", 0);
			int index1;

			for (index1 = 0; index1 < list.size(); index1++) {
				
				Label nameLabel = new Label(0, index1, list.get(index1).name);
				workbookSheet.addCell(nameLabel);
				Label programLabel = new Label(1, index1, list.get(index1).branch);
				index++;
				workbookSheet.addCell(programLabel);

			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
