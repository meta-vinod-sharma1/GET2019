<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="js/vehicleForm.js"></script>
    <title>Vehicle Details</title>
    <script src="css/vehicle.css"></script>
    <script src="js/empRegistrationValidation.js"></script>
   
</head>

<body>
	<%@include file="header.jsp" %>
    <div align="center"> <h2 id="message"></h2>
    	<form id="form_vehicle_details" method="POST" action="VehiclePlan">
            <div id="vehicle_form_div">
                <table width="">
                    <caption style="font-size: 20px">Vehicle Details</caption>
                    <tr>
                        <td>
                            Vehicle Name
                        </td>
                        <td>
                            <input type="text" name="vname" value="" placeholder="Full Name" id="vname">
                        </td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>
                            <select name="vtype" id="select_vehicle">
                                <option value="Cycle">Cycle</option>
                                <option value="Motorcycle">Motor-Cycle</option>
                                <option value="Car">Car</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Vehicle Number</td>
                        <td><input type="text" name="vnumber" placeholder="vehicle number" id="vehicle_number">
                        </td>
                    </tr>
                    <tr>
                        <td>Employee Id</td>
                        <td><input type="text" name="empId" value="<%=request.getAttribute("empId") %>" id="emp_id" readonly></td>
                    </tr>
                    <tr>
                        <td>Identification</td>
                        <td> <textarea rows="5" cols="30" name="identification" placeholder="Write here.....">
                                                 </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="vehicle_details()" value="Register Vehicle"
                                id="register_vehicle"></td>
                    </tr>

                </table>
            </div>
            <div id="plan_div" style="display: none">
                    <hr>
                    <div>
                        <h2>Choose Your Plan</h2>
                        <span>Selected Vehicle :</span> <span id="selected_vehicle"></span>
                    </div>
                    <div style="padding: 20px">
                        <span>Change Your Currency :</span>
                        <select name="currency" onchange="changeCurrency()" id="currency">
                            <option value="USD">USD</option>
                            <option value="INR">INR</option>
                            <option value="YEN">YEN</option>
                        </select>
                    </div>
                    <div>
                        <table>
                            <th>Period</th>
                            <th>Price(<span id="sign"></span>)</th>
                            <tr>
                                <td>
                                    <input type="radio" name="price" value="" id="dprice" checked> Daily
                                </td>
                                <td>
                                    <span id="daily_price"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="radio" name="price" value="" id="mprice"> Monthly
                                </td>
                                <td>
                                    <span id="monthly_price"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="radio" name="price" value="" id="yprice"> Yearly
                                </td>
                                <td>
                                    <span id="year_price"></span>
                                </td>
                            </tr>
                        </table>
                        <input type="Submit" value="GET PASS">
                    </div>
                </div>

        </form>
    </div>
        

    


</body>

</html>