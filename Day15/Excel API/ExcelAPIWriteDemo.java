package day15;

import java.io.*;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class ExcelAPIWriteDemo {
	
	private String outputFilePath;
	
	public void setOutputFile(String outputFilePath) {
	    this.outputFilePath = outputFilePath;
	    }
	
	public void writeData() throws Exception {
		
		WritableWorkbook workBook = Workbook.createWorkbook(new File(outputFilePath));
		
		workBook.createSheet("Trial", 0);
		WritableSheet sheet = workBook.getSheet(0);
		
		CellView cv = new CellView();
		cv.setAutosize(true);
	        
		 Label label;
	     label = new Label(2, 2, "AISHU");
	     sheet.addCell(label);
	
	     
	     label = new Label(2, 3, "ELANGO");
	     sheet.addCell(label);
	    
	     
	     workBook.write();
	     workBook.close();
	}
	 
	
	public static void main(String[] args) throws Exception {
        ExcelAPIWriteDemo test = new ExcelAPIWriteDemo();
        test.setOutputFile("C:\\Users\\AISHWARYA\\Desktop\\Presidio\\Demo11.xls");
        test.writeData();
        System.out.println("SUCCESSFUL ");
    }
}
 