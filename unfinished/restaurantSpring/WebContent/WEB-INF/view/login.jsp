<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>login</title>
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="backimage">
		<div class="form">
			<div class="errors">
				<br>${username} ${loginErrorMessage} ${loggedOut} ${message }<br>
			</div>
			<form action="http://localhost:8080/restaurantSpring/restaurant/food"
				method="post">
				<input type="text" placeholder="username" name="userName" required autofocus/> <input
					type="password" placeholder="password" name="password" required /> <input
					type="submit" value="login"> <input type="button"
					value="sign up"
					onclick="window.location.href='http://localhost:8080/restaurantSpring/restaurant/add';" />
			</form>
		</div>
	</div>
</body>
</html>