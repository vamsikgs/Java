<html>
<head>
<title>logout</title>
</head>
<body>
	<a href="http://localhost:8080/restaurantSpring/restaurant/login"> login</a>
	<% session.invalidate();  %>
	logged out
</body>
</html>