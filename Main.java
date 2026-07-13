package com.student;

public class Main {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Student s = new Student(10,"Shanthi","IT",100,23);
		//ExcelExporter exporter =  new ExcelExporter();
		// exporter.exportToExcel();
		
				               		
		//dao.addStudent(s);
		//dao.viewStudents();
		//dao.searchStudent(4);
		//dao.updateStudent(3,45);
		//dao.viewStudents();
		//dao.deleteStudent(7);
		//dao.viewStudents();
		//dao.addStudent(s);
		//dao.viewStudents();
		//dao.averageMarks();
//		dao.maxMarks();
//		dao.minMarks();
		dao.totalStudents();
		//dao.sortByName();
		//dao.sortByMarks();
		//dao.displayGrades();
		//dao.departmentWiseCount();
		//dao.displayResult();
		//dao.topper();
		//dao.updateMarks(7,100);
		//dao.viewStudents();
		
		//exporter.exportToExcel();
		
	}
}
