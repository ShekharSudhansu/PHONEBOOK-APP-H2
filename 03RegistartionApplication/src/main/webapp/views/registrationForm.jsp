<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<h1 style="color: red; text-align: center;">
	<u>User Registartion Form</u>
</h1>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>
	<center>
		<font color="green">${succMsg}</font>
	</center>
</h2>
<script type="text/javascript" src="js/jquery.min.js">
 
</script>
<body style="background-color: #784212">
	<form:form action="/registerUserDetails" modelAttribute="details">
		<center>
			<table
				style="background-color: yellow; text-align: center; border-color: black"
				border="1">
				<tr style="color: red">
					<td style="color: red">Name</td>
					<td style="color: green"><form:input path="uName" /></td>

				</tr>
				<tr>
					<td style="color: red">Email</td>
					<td style="color: green"><form:input path="uEmail" />
						<div id="dupEmailId"></div></td>
				</tr>
				<tr>
					<td style="color: red">Phone No</td>
					<td style="color: green"><form:input path="phNo" /></td>
				</tr>
				<tr>
					<td style="color: orange"><input type="submit" value="submit" /></td>
					<td style="color: orange"><input type="reset" value="reset" /></td>
				</tr>
			</table>
			<script type="text/javascript">
		
		 $(document).ready(function() { 
			 $("#uEmail").blur(function(){
					alert(123);
					$("#dupEmailId").html("");
					var emailId=$("#uEmail").val();
					$.ajax({
						url:'validate?emailId='+emailId ,
						success: function(data){
							if(data=='Duplicate'){
								$("#dupEmailId").html("Email already register");
								$("#dupEmailId").focus();
							}
						}
					});
				});
				
			});
		
		</script>

		</center>
	</form:form>
</body>
