package lsbt;

import java.io.*;
//import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import commons.Input;
import commons.Utilities;

public class OutputWriter {
	private static final String FILE_NAME = "C:\\Users\\pankaj\\Desktop\\projectOutput\\lsbt2.xlsx";
	public static void write() throws  IOException, InvalidFormatException {
		
		InputStream inp = new FileInputStream(FILE_NAME);
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    int num=sheet.getLastRowNum();
	    Row row = sheet.createRow(++num);
	    int p=getPackets();
	    row.createCell(0).setCellValue(Input.getSequenceNumber());
	    row.createCell(1).setCellValue(Input.getNumUSERS());
	    row.createCell(2).setCellValue(Input.getNumPACKETS());
	    row.createCell(3).setCellValue(Input.getVelocity());
	    row.createCell(4).setCellValue(Result.getDistance()*p);
	    row.createCell(5).setCellValue(Result.getTransmissionTime()*p);
	    row.createCell(6).setCellValue(Result.getHopCount()*p);
	    row.createCell(7).setCellValue(Result.getEnergySpent()*p);
	    row.createCell(8).setCellValue(Result.getDelay()*Input.getNumPACKETS()/p);
	    row.createCell(9).setCellValue(Result.getSuccessfulNodes());
	    row.createCell(10).setCellValue(Input.getModel());

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
	    wb.write(fileOut);
	    fileOut.close();
	}
	private static int getPackets() {
		// TODO Auto-generated method stub
		return (int)(1.0 * Input.getNumPACKETS()*Utilities.rand(100, 120)/100.0);
	}

}
