<%@ page import="java.util.*, com.vam.web.sl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple List of People</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Person list</h2>
		</div>
	</div>
	<br>
	<input type="button" value="Add Person"
		onclick="window.location.href='addPersonForm.jsp';return false;"
		class="addPersonButton" />
	<form action="PersonServletController" method="get">
		<input type="hidden" name="command" value="SEARCH" /> Search Person: <input
			type="textbox" name="theSearchName" /> <input type="submit"
			value="Search" class="addPersonButton" />
	</form>
	<div id="container">
		<div id="content">
			<table border="1">
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempPerson" items="${PERSON_LIST}">
					<c:url var="tempLink" value="PersonServletController">
						<c:param name="command" value="LOAD" />
						<c:param name="personId" value="${tempPerson.id }" />
					</c:url>
					<c:url var="deleteLink" value="PersonServletController">
						<c:param name="command" value="DELETE" />
						<c:param name="personId" value="${tempPerson.id }" />
					</c:url>
					<tr>
						<td>${tempPerson.firstName }</td>
						<td>${tempPerson.lastName }</td>
						<td>${tempPerson.email }</td>
						<td><a href="${tempLink}">Update </a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('are you sure you want to delete this person?')))return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>