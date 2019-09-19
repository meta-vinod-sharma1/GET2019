<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script src="js/empRegistrationValidation.js"></script>
    <title>Registration</title>
<title>Employee Registration</title>
</head>
<body>
	<%@include file="header.jsp" %>
 
 	<div class="container">
  <form:form  modelAttribute="employeeCommands"> <!--  modelAttribute="userCommands"  -->
  <!-- Gobal Error for unique email id -->
  <form:errors  cssClass="text-danger"/>
  <div class="form-group">
    <form:label path="name">Name</form:label>
    <form:input  path="name" cssClass="form-control" id="name" placeholder="Enter Your Name"/>
    <form:errors path="name" cssClass="text-danger" />
  </div>
  <div class="form-group">
  <form:label path="gender">Gender : </form:label>
   <form:radiobutton path = "gender" value = "Male" label = "Male" />
  	<form:radiobutton path = "gender" value = "Female" label = "Female" />
  	<form:radiobutton path = "gender" value = "Other" label = "Other" />
  	<form:errors path="gender" cssClass="text-danger"></form:errors>
  </div>
  <div class="form-group">
    <form:label path="email">Email address</form:label>
    <form:input type="email" path="email"   cssClass="form-control" id="email"  placeholder="Enter Your email Address"/>
    <form:errors path="email" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="password">Password</form:label>
    <form:input type="password" path="password"   cssClass="form-control" id="password"  placeholder="Enter password"/>
    <form:errors path="password" cssClass="text-danger" />
    <span id="epassword" class="text-danger"></span>
  </div>
  <div class="form-group">
    <form:label path="confirmPassword">Confirm Password</form:label>
    <form:input  path="confirmPassword" type="password"   cssClass="form-control" id="confirm_password"  placeholder="Re-enter password"/>
    <form:errors path="confirmPassword" cssClass="text-danger" />
    <span id="econfirm_password" class="text-danger"></span>
  </div>
  <div class="form-group">
    <form:label path="phoneNumber">Phone Number</form:label>
    <form:input path="phoneNumber" type="number"   cssClass="form-control" id="exampleInputEmail1"  placeholder="your mobile number"/>
    <form:errors path="phoneNumber" cssClass="text-danger" />
  </div>
  <div class="form-group">
  <form:label path="organization">Organization</form:label>
   <form:select path="organization" cssClass="form-control" value="select your organization">
                                <form:option value="Metacube">Metacube</form:option>
                                <form:option value="IBM">IBM</form:option>
                                <form:option value="CarDekho">CarDekho</form:option>
                                <form:option value="Google">Google</form:option>
                            </form:select>
  </div>
 
  <button type="submit"  class="btn btn-primary">Submit</button>
	</form:form>
</div>
</body>
</html>