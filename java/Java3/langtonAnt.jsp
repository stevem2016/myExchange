<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Langton Ant</title>
</head>
<body>
<h3>Langton Ant in JSP</h3>
<h4>(lattice size: ${latticeSize}, iteration count: ${iteration})</h4>
<div style="font-family: monospace; font-size: xx-small">
	<c:forEach var="row" items="${lattice}">
		<br>
		<c:forEach var="row_item" items="${row}">
			<c:choose>
				<c:when test="${row_item.color == 'BLACK'}">B</c:when>
				<c:when test="${row_item.color == 'WHITE'}">&nbsp;</c:when>
				<c:otherwise>?</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:forEach>
</div>
</body>
</html>