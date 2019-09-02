<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="/EAD-Session3/js/studentFormValidation.js"></script>
<link rel="stylesheet" href="/EAD-Session3/css/form.css">
<title>Update Student</title>
</head>
<body>
	<div align= center>
	<%@ page import = "com.database.DataBaseOperation" %>
	<%@ page import = "com.database.Student" %>
	
    <%  int studentId = Integer.parseInt(request.getParameter("studentId"));
        DataBaseOperation db = new DataBaseOperation(); 
		Student studentObj = db.getStudentById(studentId);
		String firstName = studentObj.getFirstName();
		String lastName = studentObj.getLastName();
		String fatherName = studentObj.getFatherName();
		String email = studentObj.getEmail();
		int classNo = studentObj.getClassNo();
		int age = studentObj.getAge();
	%>
	 
	</h1>
        <h1>Update Student Details</h1> <hr>
        <form action="Update"  onsubmit="return studentFormValidation()" method="PUT"  >
            <table>
                <tr>
                    <td> <input type="hidden" name="studentId" value=<%=studentId %> >  </td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="fname" value=<%=firstName %>  placeholder="first name" id="fname" >
                        <br> <span id="efname"></span>
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lname" id="lname" value=<%=lastName %> placeholder="last name" >
                        <br> <span id="elname"></span>
                    </td>
                </tr>
                <tr>
                    <td>Father Name</td>
                    <td><input type="text" name="father_name" id="fatherName" value= <%=fatherName %> placeholder="father name" >
                        <br> <span id="efatherName"></span>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" id="email" value=<%=email %> placeholder="email">
                        <br> <span id="eemail"></span>
                    </td>
                </tr>
                <tr>
                    <td>Class</td>
                    <td><input type="number" name="class" value= <%=classNo %> id="classNo" min="1" max="12">
                        <br> <span id="eclassNo"></span>
                    </td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="number" name="age" value=<%=age %> id="age" min="3" max="35">
                        <br> <span id="eage"></span>
                    </td>
                </tr>              
            </table>
            <input type="submit"  value="Update">
        </form>
    </div>

</body>
</html>