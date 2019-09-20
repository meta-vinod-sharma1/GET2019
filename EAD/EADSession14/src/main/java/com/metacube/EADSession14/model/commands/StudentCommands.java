/**
 * 
 */
package com.metacube.EADSession14.model.commands;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This is Entity Class or pojo class for Students 
 * @author Vinod
 *
 */
@Entity
@Table(name= "student_details")
public class StudentCommands implements Serializable{
	

	@Id@GeneratedValue
	@Column(name= "studentId")
	private int id;
	
	@Pattern(regexp="^[a-zA-Z ]{0,15}",message="first name should be alphabetical")
	@Size(min = 2, max =  15,message = "{fName}")
	@Column(name= "firstName")
	private String fName;
	
	@Pattern(regexp="^[a-zA-Z ]{0,15}",message="last name should be alphabetical")
	@Size(min=2, max =15, message = "{lName}")
	@Column(name= "lastName")
	private String lName;
	
	@Pattern(regexp="^[a-zA-Z ]{0,50}",message="father name should be alphabetical")
	@Size(min = 2, max = 50, message = "{blankFatherName}")
	@Column(name= "fatherName")
	private String fatherName;
	
	@Pattern(regexp="\\S+@\\S+\\.\\S{0,100}",message="Invalid Email")
	@NotBlank(message="{blankEmail}")
	@Column(name= "email")
	private String email;
	
	
	@NotBlank
	@Pattern(regexp="^[0-9]{0,2}",message="class should be interger with max 2 digit") 
	@Column(name= "classNo")
	private String classNo;
	
	@Pattern(regexp="^[0-9]{0,2}",message="Age should be interger with max 2 digit")
	@NotBlank
	@Column(name= "age")
	private String age;
	
	
	/**
	 * This method used to get id of Student
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * This method used to set id of the student
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method used get first name of the student
	 * @return
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * This method used to set first name of the student
	 * @param fName
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * This method used to get last name of the student
	 * @return
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * This method used to set last name of the student
	 * @param lName
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * This method used to get father name of the student
	 * @return
	 */
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * This method used to get Email address of the student
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * This method used to get class no of the student
	 * @return
	 */
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "StudentCommands [id=" + id + ", fName=" + fName + ", lName="
				+ lName + ", fatherName=" + fatherName + ", email=" + email
				+ ", classNo=" + classNo + ", age=" + age + "]";
	}
	
	

}
