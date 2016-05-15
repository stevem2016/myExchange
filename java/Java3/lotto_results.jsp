<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lotto Results</title>
</head>
<body>
${summary}<p>
<h3>
<br>--Lottery Drawing Report--
<table>
<tr><th>Matches</th><th>Count</th><th>Percent</th></tr>
<c:forEach var="result" items="${results}" varStatus="_">
<tr><td>${_.index}</td><td>${result}</td><td>${(result/(simulation_years*104))*100}</td></tr>
</c:forEach>
</table>
</h3>
<a href="lotto_formC.html">Done Viewing</a>
</body>
</html>