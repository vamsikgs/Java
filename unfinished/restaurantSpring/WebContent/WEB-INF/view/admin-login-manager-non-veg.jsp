<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>manage nonveg</title>
</head>

<body>
			<h2>Non veg List</h2>			 
			 <input type = "button" value="Add"
			 		onclick="window.location.href='nonVeg/add';"/>
			
			<table>
				<tr>
					<th>Item Name</th>
					<th>Price(Rs.)</th>
				</tr>
				
				<c:forEach var="tempNonVegItem" items="${nonveg}">
				
				<c:url  var="updateLink" value="/restaurant/adminLoginManager/nonVeg/update">
					<c:param name="nonVegId" value="${tempNonVegItem.id }"/>
				</c:url>
				
				<c:url  var="deleteLink" value="/restaurant/adminLoginManager/nonVeg/delete">
					<c:param name="nonVegId" value="${tempNonVegItem.id }"/>
				</c:url>
				
					<tr>
						<td> ${tempNonVegItem.itemName} </td>
						<td> ${tempNonVegItem.price} </td>
						<td> <a href="${updateLink }"> update </a>
							 <a href="${deleteLink }" onclick = "if(!(confirm('are you sure')))  return false"> | delete </a> </td>
					</tr>
				</c:forEach>
						
			</table>	
			<a href="http://localhost:8080/restaurantSpring/restaurant/adminLoginManager">Back to admin manager</a>
</body>

</html>









