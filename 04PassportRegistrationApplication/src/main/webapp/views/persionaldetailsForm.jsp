<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body style="background-color: #808080">
	<h1
		style="color: #0000FF; text-align: center; background-color: #800000">Passport
		Registartion Form</h1>
	<fieldset style="border-color: green ">
		<legend style="color: cyan; text-align: center;">
			<h1>Persional Details</h1>
		</legend>
		<table border="1" style="border-color: yellow" align="center">
			<form:form action="/handlePDbtn"
				modelAttribute="persionalDetailsBean">
				<tr>
					<td style="color: #F1C40F">First Name</td>
					<td><form:input path="fname" /></td>
				</tr>

				<tr>
					<td style="color: #F1C40F">Last Name</td>
					<td><form:input path="lname" /></td>
				</tr>

				<tr>
					<td style="color: #F1C40F">Email Id</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td style="color: #F1C40F">Gender</td>
					<td style="color: cyan"><form:radiobutton path="gender" value="Male" />Male
						<form:radiobutton path="gender" value="female" />Female
					</td>
				</tr>
				<tr>
					<td style="color: #F1C40F">Date Of Birth</td>
					<td><form:input path="dob" type="date"/></td>
				</tr>
				<tr style="text-align: center">
					<td colspan="3"><input type="submit" value="Next"></td>
				</tr>

			</form:form>

		</table>
	</fieldset>

</body>
