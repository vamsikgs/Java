<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add veg</title>
</head>

<body>
		
			<h3>Add veg item</h3>
	
		<form:form action="save" modelAttribute="veg" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Item name:</label></td>
						<td><form:input path="itemName" /></td>
					</tr>
				
					<tr>
						<td><label>Price(Rs.)</label></td>
						<td><form:input path="price" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				
				</tbody>
			</table>
		<a href="http://localhost:8080/restaurantSpring/restaurant/adminLoginManager/veg">back to veg list</a>
		
		</form:form>
	
</body>

</html>










