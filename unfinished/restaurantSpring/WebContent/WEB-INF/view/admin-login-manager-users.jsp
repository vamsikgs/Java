<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>Users</title>
</head>

<body>
			<h2>Users List</h2>			 
			 <input type = "button" value="Add"
			 		onclick="window.location.href='users/add';"/>
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Username</th>
				</tr>
				
				<c:forEach var="tempUser" items="${users}">
				
				<c:url  var="updateLink" value="/restaurant/adminLoginManager/users/update">
					<c:param name="userId" value="${tempUser.id }"/>
				</c:url>
				
				<c:url  var="deleteLink" value="/restaurant/adminLoginManager/users/delete">
					<c:param name="userId" value="${tempUser.id }"/>
				</c:url>
				
					<tr>
						<td> ${tempUser.firstName} </td>
						<td> ${tempUser.lastName} </td>
						<td> ${tempUser.email} </td>
						<td> ${tempUser.userName} </td>
						<td> <a href="${updateLink }"> update </a>
							 <a href="${deleteLink }" onclick = "if(!(confirm('are you sure')))  return false"> | delete </a> </td>
					</tr>
				</c:forEach>
						
			</table>	
			<a href="http://localhost:8080/restaurantSpring/restaurant/adminLoginManager">Back to admin manager</a>
</body>

</html>









