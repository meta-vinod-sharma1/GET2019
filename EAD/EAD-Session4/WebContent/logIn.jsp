<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/RegisterForm.css">
<script src="js/logInValidation.js"></script>
<title>Log In</title>
</head>
<body>
	<%@include file="header.jsp" %>
    <div class="tableDiv">
        <form action="Login" onsubmit=" return logInValidation()" method="post">
            <table>
                <tr>
                    <td>
                        Email Id
                    </td>
                    <td>
                        <input type="text" name="email" id="email"value="">
                        <br>
                            <span class="error" id="eemail"></span>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td> <input type="password" id="password" name="password" >
                        <br>
                        <span class="error" id="epassword"></span>
                    </td>
                </tr>
                <tr> <td>  <input type="submit" value="Log In"></td>
                	<td><a href="registration.jsp"> Register Account</a> </td>
                </tr>
            </table>
        </form>
        
    </div>




</body>
</html>