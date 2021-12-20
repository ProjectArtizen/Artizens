<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javaScript">
	<c:set var="creator" value="${creator}" />
	<c:choose>
		<c:when test="${creator == '크리에이터를 등록해 주세요.'}">
			alert("크리에이터를 등록해 주세요.");
			location.href="/artizen/artwork/main";
		</c:when>
	</c:choose>
</script>