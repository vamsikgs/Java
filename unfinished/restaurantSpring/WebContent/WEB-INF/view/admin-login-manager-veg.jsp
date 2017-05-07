<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>manage veg</title>
</head>

<body>
			<h2>Veg List</h2>			 
			 <input type = "button" value="Add"
			 		onclick="window.location.href='veg/add';"/>
			
			<table>
				<tr>
					<th>Item Name</th>
					<th>Price(Rs.)</th>
				</tr>
				
				<c:forEach var="tempVegItem" items="${veg}">
				
				<c:url  var="updateLink" value="/restaurant/adminLoginManager/veg/update">
					<c:param name="vegId" value="${tempVegItem.id }"/>
				</c:url>
				
				<c:url  var="deleteLink" value="/restaurant/adminLoginManager/veg/delete">
					<c:param name="vegId" value="${tempVegItem.id }"/>
				</c:url>
				
					<tr>
						<td> ${tempVegItem.itemName} </td>
						<td> ${tempVegItem.price} </td>
						<td> <a href="${updateLink }"> update </a>
							 <a href="${deleteLink }" onclick = "if(!(confirm('are you sure')))  return false"> | delete </a> </td>
					</tr>
				</c:forEach>
						
			</table>	
			<a href="http://localhost:8080/restaurantSpring/restaurant/adminLoginManager">Back to admin manager</a>
</body>

</html>









