<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <title>Sign Up</title>
  </head>
  <body>
  <div class="container">
  <form:form modelAttribute="studentCommands"> <!--  modelAttribute="userCommands"  -->
  <!-- Gobal Error for unique email id -->
  <form:errors  cssClass="text-danger"/>
  <div class="form-group">
    <form:label path="fName">First Name</form:label>
    <form:input  path="fName" cssClass="form-control" id="nameInputEmail1" placeholder="Enter First Name"/>
    <form:errors path="fName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="lName">Last Name</form:label>
    <form:input  path="lName" cssClass="form-control" id="nameInputEmail1" placeholder="Enter Last Name"/>
    <form:errors path="lName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="fatherName">Father Name</form:label>
    <form:input  path="fatherName" cssClass="form-control" id="nameInputEmail1" placeholder="Enter Father's Name"/>
    <form:errors path="fatherName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="email">Email address</form:label>
    <form:input path="email"   cssClass="form-control" id="exampleInputEmail1"  placeholder="Enter email"/>
    <form:errors path="email" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="classNo">Class</form:label>
    <form:input path="classNo"   cssClass="form-control" id="exampleInputEmail1"  placeholder="Enter class"/>
    <form:errors path="classNo" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="age">Age</form:label>
    <form:input path="age"   cssClass="form-control" id="exampleInputEmail1"  placeholder="Enter age"/>
    <form:errors path="age" cssClass="text-danger" />
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</div>
  
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="/js/bootstrap-4.3.1-dist/js/bootstrap.min.js" ></script>
  </body>
</html>