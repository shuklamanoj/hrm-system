<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
</head>
<body>
<H1>Admin Portal</H1>
<hr/>
<h3>Login to enter</h3>
<span style="color: red;"><c:out value="${errorMessage }" /></span>
<form action="<%=request.getContextPath() %>/adminLogin" method="POST" >
<input type="hidden" name="task" value="login-form"/>
Enter email : <input type="email" name="email" /> <br>
Enter Password : <input type="password" name="passwd" /><br>
<input type="submit" value="LOGIN" />
</form>
</body>
</html>