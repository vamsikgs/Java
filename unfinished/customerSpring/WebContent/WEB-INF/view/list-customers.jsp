<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
</head>

<body>
			<h2>Customer Table</h2>			 
			 <input type = "button" value="Add"
			 		onclick="window.location.href='add';"/>
			
			<table>
				<tr>
					<th><input type="checkbox" /><th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url  var="updateLink" value="/customer/update">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
				<c:url  var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> <a href="${updateLink }"> update </a>
							 <a href="${deleteLink }" onclick = "if(!(confirm('are you sure')))  return false"> | delete </a> </td>
					</tr>
				</c:forEach>
						
			</table>	
</body>

</html>









