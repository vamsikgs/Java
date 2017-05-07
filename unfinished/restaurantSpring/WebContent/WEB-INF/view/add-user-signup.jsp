<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>sign up</title>
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="backimage">
		<div class="form">
			<div class="errors">
				<br> ${username} ${message} <br>
			</div>
			<form:form
				action="http://localhost:8080/restaurantSpring/restaurant/signup/save"
				modelAttribute="user" method="POST">
				<form:hidden path="id" />

				<label>First name:</label>
				<form:input type="text" path="firstName" />


				<label>Last name(*):</label>
				<form:input path="lastName" />
				<form:errors path="lastName"></form:errors>


				<label>Email(*):</label>
				<form:input path="email"/>
				<form:errors path="email"></form:errors>



				<label>Username(*):</label>
				<form:input type="text" path="userName" />
				<form:errors path="userName"></form:errors>


				<label>Password(*):</label>
				<form:input type="password" path="password" />
				<form:errors path="password"></form:errors>


				<label></label>
				<input type="submit" value="Save" />


			</form:form>
		</div>
	</div>
</body>
</html>

