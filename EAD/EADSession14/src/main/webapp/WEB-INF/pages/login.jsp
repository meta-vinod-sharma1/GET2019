<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Sign Up</title>
</head>
<body>
	<div class="container">
		<span class="text-danger">${Error}</span>
		<form action="perform_login" method="post">
	  		<div class="form-group">
	    		<label>User Name</label>
	    		<input  name="username" class="form-control" placeholder="Enter username"/>
	  		</div>
	  		<div class="form-group">
	    		<label >Password</label>
	    		<input type="password"  name="password" class="form-control"  placeholder="Enter Password"/>
	  		</div>
	 
	  		<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>