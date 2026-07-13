package com.student;

public class Student {

private int id;
private String name;
private String department;
private double marks;
private int age;

public Student(int id,String name,String department,double marks,int age) {
	
		this.id=id;
		this.name = name;
		this.department=department;
		this.marks=marks;
		this.age =age;
}
public int getid() {
	return id;
}
public String getname() {
	return name;
}
public String getdepartment() {
	return department;
}
public double getmarks() {
	return marks;
}
public int getage() {
	return age;
}
}
