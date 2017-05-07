<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>non veg items</title>
</head>

<body>
			<h2>Non veg list</h2>			 
			
			<table>
				<tr>
					<th>Item Name</th>
					<th>Price(Rs.)</th>
				</tr>
				
				<c:forEach var="tempNonVegItem" items="${nonvegitems}">
				
					<tr>
						<td> ${tempNonVegItem.itemName} </td>
						<td> ${tempNonVegItem.price} </td>
					</tr>
				</c:forEach>
						
			</table>
				
</body>

</html>