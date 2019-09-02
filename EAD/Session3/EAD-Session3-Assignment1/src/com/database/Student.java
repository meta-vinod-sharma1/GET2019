package com.database;

public class Student {
	
	private int studentId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String email;
	private int classNo;
	private int age;

	public Student( int studentId,String firstName, String lastName, String fatherName, String email, int classNo, int age){
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.classNo = classNo;
		this.age = age;
	}
	
	public int getStudentId(){
		return studentId;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFatherName(){
		return fatherName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public int getClassNo(){
		return classNo;
	}
	
	public int getAge(){
		return age;
	}
	
	

}
