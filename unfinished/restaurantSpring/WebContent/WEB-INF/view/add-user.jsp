<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add user</title>
</head>

<body>
			
			<h3>Add Customer</h3>
	
		<form:form action="save" modelAttribute="user" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" required/></td>
						<form:errors path="lastName"></form:errors>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/></td>
					</tr>
					
					<tr>
						<td><label>Username:</label></td>
						<td><form:input path="userName" required/></td>
					</tr>
					
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" required/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				
				</tbody>
			</table>
		<a href="http://localhost:8080/restaurantSpring/restaurant/adminLoginManager/users">Back to users list</a>
		
		</form:form>
	
</body>

</html>










