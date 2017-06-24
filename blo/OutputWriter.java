package blo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import commons.Input;


public class OutputWriter {
	private static final String FILE_NAME = "C:\\Users\\pankaj\\Desktop\\projectOutput\\blo2.xlsx";
	public static void write() throws  IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		InputStream inp = new FileInputStream(FILE_NAME);
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    int num=sheet.getLastRowNum();
	    Row row = sheet.createRow(++num);
	    row.createCell(0).setCellValue(Input.getSequenceNumber());
	    row.createCell(1).setCellValue(Input.getNumUSERS());
	    row.createCell(2).setCellValue(Input.getNumInterestedUsers());
	    row.createCell(3).setCellValue(Input.getNumPACKETS());
	    row.createCell(4).setCellValue(Input.getVelocity());
	    row.createCell(5).setCellValue(Result.getDistanceTravelled());
	    row.createCell(6).setCellValue(Result.getDistanceTravelled()/(3*100000000));
	    row.createCell(7).setCellValue(Result.getHops());
	    row.createCell(8).setCellValue(Result.getEnergyConsumed());
	    row.createCell(9).setCellValue(Result.getDelay());
	    row.createCell(10).setCellValue(Result.getSuccessfulNodes());
	    row.createCell(11).setCellValue(Input.getModel());

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
	    wb.write(fileOut);
	    fileOut.close();
	}
}
