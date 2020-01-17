<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body style="background-color: #339933;">
	<h1 style="color: cyan; text-align: center">User Login Page</h1>
	<h1 style="color: red; text-align: center;">${errMsg}</h1>
	<form:form action="/userLogin" modelAttribute="loginBean">
		<table align="center">
			<tr>
				<td>User Email</td>
				<td><form:input path="email" /></td>
				<div id="dupEmailId"></div>
			</tr>
			<tr>
				<td>User Password</td>
				<td><form:input path="pwd" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="signIn"></td>
			</tr>
			</col>
			<tr>
				<td><a href="showForgetPwd">Forget Password</a></td>
				<td><a href="reg">signUp</a></td>
				<!-- <td><a href="displayAllRecords" style="align-content: center;">Show All User</a></td> -->
			</tr>
		</table>
		
	</form:form>
</body>