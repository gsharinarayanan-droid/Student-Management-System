package com.student;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {

	public void exportToExcel() {
		try {

	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM studentdb1";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Students");

	        // Header Style
	        Font font = workbook.createFont();
	        font.setBold(true);

	        CellStyle headerStyle = workbook.createCellStyle();
	        headerStyle.setFont(font);
	        headerStyle.setAlignment(HorizontalAlignment.CENTER);

	        // Header Row
	        Row header = sheet.createRow(0);
	        CellStyle dataStyle = workbook.createCellStyle();
	        dataStyle.setAlignment(HorizontalAlignment.CENTER);
	        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);

	        String[] columns = {"ID", "Name", "Department", "Marks","Age","Grades","Status"};

	        for (int i = 0; i < columns.length; i++) {
	            Cell cell = header.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerStyle);
	        }

	        int rowNum = 1;
	        while (rs.next()) {

	            Row row = sheet.createRow(rowNum++);

	             
            
	            row.createCell(2).setCellValue(rs.getString("department"));
	            double marks=rs.getDouble("marks");
	            row.createCell(3).setCellValue(marks);
	            row.createCell(4).setCellValue(rs.getInt("age"));
	            String grade;
	            String status;
	            if(marks>=90) 
	        		grade="A";
	        	else if(marks>=80)
	        		grade ="B";
	        	else if(marks>=70)
	        		grade ="C";
	        	else if(marks>=60)
	        		grade ="D";
	        	else if(marks>=40) 
	        		grade="E";
	        	
	        	else
	        		grade="F";
	            status=(marks>=50)?"Pass":"Fail";
	            Cell cell0 =row.createCell(0);
	            cell0.setCellValue(rs.getInt("id"));
	            cell0.setCellStyle(dataStyle);
	            
	            Cell cell1 = row.createCell(1);
	            cell1.setCellValue(rs.getString("name"));
	            cell1.setCellStyle(dataStyle);
	            
	            Cell cell2 = row.createCell(2);
	            cell2.setCellValue(rs.getString("department"));
	            cell2.setCellStyle(dataStyle);
	            
	            Cell cell3 = row.createCell(3);
	            cell3.setCellValue(marks);
	            cell3.setCellStyle(dataStyle);
	            
	            Cell cell4 = row.createCell(4);
	            cell4.setCellValue(rs.getInt("age"));
	            cell4.setCellStyle(dataStyle);
	            
	            Cell cell5 = row.createCell(5);
	            cell5.setCellValue(grade);
	            cell5.setCellStyle(dataStyle);
	            
	            Cell cell6 = row.createCell(6);
	            cell6.setCellValue(status);
	            cell6.setCellStyle(dataStyle);
	            
	        }

	        // Auto Size Columns
	        for (int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        FileOutputStream fos = new FileOutputStream("Students.xlsx");
	        workbook.write(fos);

	        fos.close();
	        workbook.close();
	        con.close();

	        System.out.println("Excel file exported successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
		
	


	


