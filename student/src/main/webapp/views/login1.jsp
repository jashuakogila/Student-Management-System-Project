<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
</head>
<body Style="text-align: center;">
	<h1>Student management system project</h1>
	<div>
		<h3>login page</h3>
		<form action="Login1servlet" method="get">
			<pre>
Enter username: <input type="text" name="username" />
Enter password: <input type="password" name="password" />
<input type="submit" value="login" />

<a href="forgot1password.jsp">Forgot password ?</a>
</pre>
		</form>

	</div>

</body>
</html>