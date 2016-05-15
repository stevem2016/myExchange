<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<c:choose>
  <c:when test="${param.degree_type == 'F'}">
    <c:out value="${param.degree_value}"/>F is <c:out value="${(param.degree_value - 32)*5/9}"/>C
  </c:when>
  <c:when test="${param.degree_type == 'C'}">
    <c:out value="${param.degree_value}"/>C is <c:out value="${(param.degree_value*9./5.) + 32}"/>F
  </c:when>
  <c:otherwise>
    Sorry, this temp converter can only do C or F for now...
  </c:otherwise>
</c:choose>

</body>
</html>