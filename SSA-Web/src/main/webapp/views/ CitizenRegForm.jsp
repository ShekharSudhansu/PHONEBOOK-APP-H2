<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body style="background-color: teal;">
	<h1 style="background-color: lime; text-align: center">Citizen
		registartion Form</h1>

	<form:form action="/handleSubmitBtn" modelAttribute="domain">
	<fieldset style="border-color: green">
	<legend style="color: cyan;background-color: maroon;">Citizen Details</legend>
	<h1 style="color: green;background-color: yellow;text-align: center">${succMsg} </h1>
		<table
			style="background-color: olive; border-color: red; border-left-width: 5"
			align="center" border="1">
			<tr>
				<td>First Name</td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobutton path="gender" value="Male" />Male
						<form:radiobutton path="gender" value="female" />Female</td>				</td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><form:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:select path="stateName">
						<form:option value="--SELECT--" />
						<form:options items="${allState}" />
					</form:select></td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="2"><input type="submit" value="Register"
					style="background-color: green; color: yellow" /></td>
			</tr>

		</table>
</fieldset>
	</form:form>


</body>



