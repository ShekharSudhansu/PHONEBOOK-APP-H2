<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 		<h1 style="color:#00ff00;text-align: center;background-color: #cc0099">All User Records</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body style="background-color: #bf00ff">

<c:choose>
	<c:when test="${listDetails}">
	<c:forEach items="${listDetails}" var="list" varStatus="status">
	<table style="background-color: #ccffff;color:#003300;font-weight:bold;" align="center">
		<tr>
			<td>User Id</td><td>${status.index+1}</td>
		</tr>
		<tr>
			<td>User Name</td><td>${list.uName}</td>
		</tr>
		<tr>
			<td>User Email</td><td>${list.uEmail}</td>
		</tr>
		<tr>
			<td>User Password</td><td>${list.uPwd}</td>
		</tr>
		<tr>
			<td>User PhoneNo</td><td>${list.phNo}</td>
		</tr>
		
		<tr>
			<td>Account Status</td><td>${list.status}</td>
		</tr>
		
	</table>
	</c:forEach>
	</c:when>
	<c:otherwise>
		<h1 style="color: red;text-align: center;">No Records Avalable</h1>
	</c:otherwise>
</c:choose>

</table>
	
</body>

