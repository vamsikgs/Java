<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Person</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/person-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Person list</h2>
		</div>
	</div>
	<div id="container">
		<h3>Update Person</h3>
		<form action="PersonServletController" method="get"> 
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="personId" value="${the_person.id }"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName"
							value="${the_person.firstName }" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName"
							value="${the_person.lastName }" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"
							value="${the_person.email }" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
				</table>
				</form>
				<div style="clear: both;"></div>
				<p>
					<a href="PersonServletController">Back to list</a>
				</p>
				</div>
</body>
</html>