package day15;

import java.io.*;
import jxl.*;

public class ExcelAPIReadDemo {

	String inputFilePath;
	
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	
	public void ReadData() throws Exception {
		File excelFile = new File(inputFilePath);
		
		Workbook workbook = Workbook.getWorkbook(excelFile);
		Sheet sheet = workbook.getSheet(0);
		
		Cell[] c = sheet.getColumn(1);
		for(Cell cell : c)
			System.out.println(cell.getContents());
		
		System.out.println("\n\n");
		
		for(int i = 0 ; i < sheet.getRows(); i ++) {
			for(int j = 0; j < sheet.getColumns(); j++)
				System.out.println(sheet.getCell(j, i).getContents());
			//System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
        
		ExcelAPIReadDemo obj = new ExcelAPIReadDemo();
        obj.setInputFilePath("C:\\Users\\AISHWARYA\\Desktop\\Presidio\\Demo2.xls");
        obj.ReadData();
	}
}
