<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>veg items</title>
</head>

<body>
			<h2>Veg list</h2>			 
			
			<table>
				<tr>
					<th>Item Name</th>
					<th>Price(Rs.)</th>
				</tr>
				
				<c:forEach var="tempVegItem" items="${vegitems}">
				
					<tr>
						<td> ${tempVegItem.itemName} </td>
						<td> ${tempVegItem.price} </td>
					</tr>
				</c:forEach>
						
			</table>	
			
</body>

</html>