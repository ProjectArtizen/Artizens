<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="/test-mvc" method="POST">
 	타이틀 : <input type="text" name="title" value=""/><br>
 	이름    : <input type="text" name="name" /><br>
 	<c:forEach var="item" items="${result}">
	 	결과    : ${item.title }<br> 	
 		결과    : ${item.name }<br>
 	</c:forEach>
 	<button type="submit">제출</button> 
 </form>
</body>
</html>