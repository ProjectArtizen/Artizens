<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artizen</title>
<script type="text/javascript">
	
	alert(${condition});
	if (${condition} == "noUser"){
		alert(${errors.getFieldError('noUser')});
		location.href = "../login";
	}
	if (${condition} == "noCreator"){
		alert("크리에이터 등록을 해야 콜라보레이션에 참가신청을 할 수 있습니다.");
		location.href = "../collaboration/main";
	}
	if (${condition} == "organizer"){
		alert("본인이 등록한 콜라보레이션에는 참가할 수 없습니다.");
		location.href = "../collaboration/main";
	}
	if (${condition} == "invalidRequest"){
		alert("유효하지 않은 요청입니다.");
		location.href = "../collaboration/main";
	}
</script>
</head>
<body>
	
	<c:if test="${condition} eq 'noUser'">
		<script type="text/javascript">
			alert("문제가 생겼습니다.");
			location.href = "../login";
		</script>
	</c:if>
</body>
</html>