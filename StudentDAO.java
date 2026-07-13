package com.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class StudentDAO {
	public void addStudent(Student s) {
		
		try {
			Connection con =DBConnection.getConnection();
			String sql = "Insert into studentdb1 values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,s.getid());
			ps.setString(2, s.getname());
			ps.setString(3, s.getdepartment());
			ps.setDouble(4, s.getmarks());
			ps.setInt(5, s.getage());
			int rows = ps.executeUpdate();
			System.out.println(rows+"Record inserted");
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
  public void viewStudents() {
	  try {
		  Connection con = DBConnection.getConnection();
		  Statement st = con.createStatement();
		  ResultSet rs=st.executeQuery("SELECT*FROM studentdb1");
		  while(rs.next()) {
			  System.out.println(rs.getInt("id")
			  +" "
			  +rs.getString("name")
			  +" "
			  +rs.getString("department")
			  +" "
			  +rs.getDouble("marks")
			  +" "
			  +rs.getInt("age"));
			  
			  
		  }
		  con.close();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
			  

  public void updateStudent(int id,double marks) {
	  try {
		  Connection con =DBConnection.getConnection();
		  String sql ="UPDATE studentdb1 SET marks= ? WHERE id =?";
		  PreparedStatement ps = con.prepareStatement(sql);
		  ps.setDouble(1,marks);
		  ps.setInt(2, id);
		  int rows = ps.executeUpdate();
		  System.out.println(rows+"Record updated");
		  con.close();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  public void deleteStudent(int id) {
	  try {
		  Connection con =DBConnection.getConnection();
		  PreparedStatement ps = con.prepareStatement("Delete from studentdb1 where id =?" );
		  ps.setInt(1, id);
		  int rows = ps.executeUpdate();
		  System.out.println("Record deleted");
		  con.close();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
	  
   public void searchStudent(int id) {
	   try {
		   Connection con = DBConnection.getConnection();
		   PreparedStatement ps = con.prepareStatement("SELECT *FROM studentdb1 WHERE id =?");
		   ps.setInt(1, id);
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   System.out.println("ID: "+rs.getInt("id"));
			   System.out.println("Name: "+rs.getString("name"));
			   System.out.println("Department: "+rs.getString("department"));
			   System.out.println("Marks: "+rs.getDouble("marks"));
			   System.out.println("Age: "+rs.getInt("age"));
		   }
		   else {
			   System.out.println("Student not found");
		   }
		   con.close();
	   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
   }

	public void sortByMarks() {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "SELECT *FROM studentdb1 ORDER BY marks DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id") +" "
						+rs.getString("name")+ " "
						+rs.getString("department")+ " "
						+rs.getDouble("marks")+" "
						+rs.getInt("age"));
			}
			con.close();
				
	}catch(Exception e) {
		e.printStackTrace();
			
			
		}
	}
	
public void sortByName() {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT *FROM studentdb1 ORDER BY name ASC";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("id") +" "
					+rs.getString("name")+ " "
					+rs.getString("department")+ " "
					+rs.getDouble("marks")+" "
					+rs.getInt("age"));
		}
		con.close();
			
}catch(Exception e) {
	e.printStackTrace();
	
 }
   }
 
public void searchByAge(int age) {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT *FROM studentdb1 WHERE age =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, age);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt("id") +" "
					+rs.getString("name")+ " "
					+rs.getString("department")+ " "
					+rs.getDouble("marks")+" "
					+rs.getInt("age"));
		}
		con.close();
			
}catch(Exception e) {
	e.printStackTrace();
	
 }
}

public void updateMarks(int id,double marks) {
	try {
	Connection con = DBConnection.getConnection();
	String sql = "UPDATE studentdb1 SET marks = ? WHERE id = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setDouble(1, marks);
	ps.setInt(2, id);
	int rows =ps.executeUpdate();
	System.out.println(rows+"Record updated");
	con.close();
}catch(Exception e) {
	e.printStackTrace();
}
}

public void displayGrades() {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT *FROM studentdb1 ";
		PreparedStatement ps =con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	double marks=rs.getDouble("marks");
        	String grade;
        	if(marks>=90) 
        		grade="A";
        	else if(marks>=80)
        		grade ="B";
        	else if(marks>=70)
        		grade ="C";
        	else if(marks>=60)
        		grade ="D";
        	else
        		grade="F";
        	System.out.println(rs.getInt("id")+" "
		          + rs.getString("name")+" "
		           +marks+"Grade: "+grade);
        }
     con.close();   
	}
	catch(Exception e) {
		e.printStackTrace();
	}
        		
        	
}

public void displayResult() {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT *FROM studentdb1";
		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			double marks=rs.getDouble("marks");
			String result =(marks>=50)?"PASS":"FAIL";
			System.out.println(rs.getInt("id")+" "
					          +rs.getString("name")+" "
					          +marks+" "
					          +result);
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void averageMarks() {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT AVG(marks) AS avgMarks FROM studentdb1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("Avreage Marks: "+rs.getDouble("avgmarks"));
			
		}
		
	con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
}

public void topper() {
	try {
		Connection con =DBConnection.getConnection();
		String sql= "SELECT *FROM studentdb1 ORDER BY marks DESC LIMIT 1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		if(rs.next()) {
			System.out.println("Topper");
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getDouble("marks"));
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void departmentWiseCount() {
	try {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT department,COUNT(*) AS total FROM studentdb1 GROUP BY department";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("department")
					+ " : "
					+
					rs.getInt("total"));
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
			

public void maxMarks() {
	try {
		Connection con =DBConnection.getConnection();
		String sql ="SELECT MAX(marks) AS max_marks FROM studentdb1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Maximum marks: "+rs.getDouble("max_marks"));
		}
		con.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void minMarks() {
	try {
		Connection con =DBConnection.getConnection();
		String sql ="SELECT MIN(marks) AS min_marks FROM studentdb1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Minimum marks: "+rs.getDouble("min_marks"));
		}
		con.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	
}
}
public void totalStudents() {
	try {
		Connection con =DBConnection.getConnection();
		String sql = "SELECT COUNT(*) AS total FROM studentdb1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Total Students: "+rs.getInt("total"));
		}
		con.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
		
		
		
			
		

	

	
			   
			   
			   
			   
			   
			   
		   