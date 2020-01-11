package tpMediateur;

import java.io.File;
import java.io.FileInputStream;


import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;


public class AdaptateurExcel {
	
	
	
	
	public AdaptateurExcel() {
		
	}

	public void connexion() throws IOException{
		
	
		FileInputStream fis=new FileInputStream(new File("albumlist-Rock-Apres 1970.xlsx")); 
		XSSFWorkbook wb=new XSSFWorkbook(fis);      
		XSSFSheet sheet1 =wb.getSheetAt(0); 
		XSSFSheet sheet2 =wb.getSheetAt(1); 
		
		FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
		for(Row row: sheet1)     
		{  
		for(Cell cell: row)    
		{  
		switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
		{  
		  case Cell.CELL_TYPE_NUMERIC:    
		  System.out.print(cell.getNumericCellValue()+ "\t\t");   
		  break;  
		  case Cell.CELL_TYPE_STRING:   
		  System.out.print(cell.getStringCellValue()+ "\t\t");  
		 break;  
		}  
	   }
	}

    } 
}
