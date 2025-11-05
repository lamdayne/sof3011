<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/user/index">Show User</a>
	<ul>
		<c:forEach var="item" items="${items}" varStatus="vs">
			<li>${vs.count} - ${item.fullName}</li>
		</c:forEach>
	</ul>
</body>
</html>