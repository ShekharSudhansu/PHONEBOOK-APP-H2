<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 	<h1 style="background: blue;text-align: center;color: cyan">User Registration Form</h1>
 	<form:form action="registerUserDetails" >
 		<table style="background: mauve;color: maroon;border-color: green; background-image: url(images/registration.jfif)" border="1" align="center">
 		<tbody style="background-color:cyan">
 			<tr ><td>First Name</td><td><form:input path="fName"/></td></tr>
 			<tr ><td>Last Name</td><td><form:input path="lName"/></td></tr>
 			<tr ><td>Email</td><td><form:input path="eMail"/></td></tr>
 			<tr ><td>PhoneNo</td><td><form:input path="phoneNo"/></td></tr>
 			<tr ><td>Gender</td><td><form:radiobutton path="gender" value="M"/>&nbsp;&nbsp;<form:radiobutton path="sex" value="F"/>
 			</td></tr>
 			<tr><td>Country Name</td><td><form:select path="countryName">
</form:select></td></tr>
 			
 		</tbody>
 		</table>
 	
 	</form:form>
 	
 		
 	
 	
 	