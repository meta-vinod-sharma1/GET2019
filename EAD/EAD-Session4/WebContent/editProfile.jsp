<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/empRegistrationValidation.js"></script>
<link rel="stylesheet" href="css/RegisterForm.css">
<title>Update Profile</title>
</head>
<body>
	<%@ page import = "com.parking.database.DatabaseOperation" %>
	<%@ page import = "com.parking.pojo.Employee" %>
	<%@include file="header.jsp" %>
	
    <%  String email = (String)session.getAttribute("email");
        DatabaseOperation db = new DatabaseOperation(); 
		Employee obj = db.getEmployeeByEmail(email);
	%>

    <div align="center">
        <h1 align="center">Metacube Parking Registration</h1>
        <hr>
        <div>
            <form action="Update" onsubmit="return empFormValidation()" method="post">
                <table>
                    <caption style="font-size: 20px">Employee Details</caption>
                    <tr>
                        <td>
                            Full name
                        </td>
                        <td>
                            <input type="text" name="name" value=<%=obj.getName() %> placeholder="Full Name" id="name"> <br>
                            <span class="error" id="ename"></span>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>Gender </td>
                        <td>
                            <input type="radio" name="gender" value="male" checked>
                            <label for="male">Male</label>

                            <input type="radio" name="gender" value="female">
                            <label for="female">Female</label>

                            <input type="radio" name="gender" value="other">
                            <label for="other">Other</label>
                        </td>

                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" value=<%= obj.getEmail() %> placeholder="Your Email Id" id="email" readonly>
                            <br>
                            <span class="error" id="eemail"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value=<%=obj.getPassword() %>  placeholder="password" id="password">
                            <br>
                            <span class="error" id="epassword"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirm_password" placeholder="confirm password"
                                id="confirm_password">
                                <br>
                            <span class="error" id="econfirm_password"></span>
                            
                            </td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td> <input type="number" name="number" value=<%=obj.getPhoneNumber() %> placeholder="phone number" id="number">
                            <br>
                            <span class="error" id="enumber"></span>
                        
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Organization
                        </td>
                        <td>
                            <select name="org" id="">
                                <option value="Metacube">Metacube</option>
                                <option value="IBM">IBM</option>
                                <option value="CarDekho">CarDekho</option>
                                <option value="Google">Google</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="Submit" value="Update"  id="register_emp">
                        </td>
                    </tr>

                </table>
            </form>
        </div>
</body>
</html>