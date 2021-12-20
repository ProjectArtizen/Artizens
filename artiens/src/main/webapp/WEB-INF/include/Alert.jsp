<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javaScript">
	<c:set var="Id" value="${userid}" />
	<c:choose>
		<c:when test="${Id == null }">
			
		</c:when>
	</c:choose>
</script>