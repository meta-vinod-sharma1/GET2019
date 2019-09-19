<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="css/RegisterForm.css">
<title>Upload File Request Page</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="tableDiv">
        <form method="POST" action="uploadPhoto" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        File to upload:
                    </td>
                    <td>
                        <input type="file" name="file"><br />
                        <br>
                            <span class="error" id="eemail"></span>
                    </td>
                </tr>
                <tr> <td>  <input type="submit" value="Upload"></td>
                </tr>
            </table>
        </form>
        
    </div>
</body>
</html>