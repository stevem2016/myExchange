<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A few ways to inject a local variable</title>
</head>
<body>

<br>Use a literal:
<c:set var="x" value="8"></c:set>
value of x is ${x}

<br>Use an EL expression:
<c:set var="y" value="${(x*2)/13}"></c:set>
 And the value of y is ${y}

<br>Use a scriptlet (last resort):
<% int i = 8;
   request.setAttribute("z",i);
 %>
 And the value of z is ${z}

</body>
</html>