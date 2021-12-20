<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:set var="creator" value="${creator }" />
	<c:set var="message" value="${message }" />

<script language="javaScript">
	<c:choose>
		<c:when test="${creator == '크리에이터를 등록해 주세요.'}">
			alert("크리에이터를 등록해 주세요.");
			location.href="/artizen/artwork/main";
		</c:when>
		<c:when test="${ message == 'ok'}">
			alert("크리에이터 등록 및 작품 등록에 성공하였습니다.");
			opener.location.reload();
			window.close();
		</c:when>
	</c:choose>
</script>