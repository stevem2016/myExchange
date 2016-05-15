<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<c:forEach var="next" items="${alpha_soup}" begin="3" end="9" step="3" varStatus="info">
<br><c:out value="${next}"/>: first=${info.first} last=${info.last} index=${info.index} count=${info.count}
</c:forEach>
</body>
</html>