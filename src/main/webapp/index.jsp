<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	这是springmvc0309第一个页面
	<form action="AddAdminServlet" method="post">
	<input type="text" name="addAdminJson">
		userName<input type="text" name="name" value=${dpInfo.dp_name }><br/>
		password<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
	
	<form action="example/book/save" method="post">
		bookid<input type="text" name="bookid"><br/>
		bookName<input type="text" name="bookName"><br/>
		price<input type="text" name="price"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>