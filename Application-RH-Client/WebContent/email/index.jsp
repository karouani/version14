<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="css/main.css" rel="stylesheet">

<title>Email Form</title>
</head>
<body>
	<h3 class="notice">The form below uses Google's SMTP server. So you need to enter
		a gmail username and password </h3>

	<form action="sendEmail" method="post">
		<table>
			<tr>
				<td><label for="login">login : </label></td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td><label for="password">Password : </label></td>
				<td><input type="text" name="password" /></td>
			</tr>
			
			<tr>
				<td><label for="recipient">To :</label></td>
				<td><input type="text" name="recipient" /></td>
			</tr>

			<tr>
				<td><label for="subject">Subject :</label></td>
				<td><input type="text" name="subject" /></td>
			</tr>

			<tr>
				<td><label for="message">Message :</label></td>
				<td><textarea rows="" cols="" name="message" ></textarea></td>
			</tr>

			
			<tr>
				<td></td>
				<td colspan='2'><input type="submit" value="Send Email" /></td>
			</tr>
		</table>
	</form>
</body>
</html>