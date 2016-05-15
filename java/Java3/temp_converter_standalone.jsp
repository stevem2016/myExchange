<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#table {
	display: table;
}
.row {
	display: table-row;
}
.cell {
	display: table-cell;
	padding: 4px;
}
</style>
</head>
<body>

	<h2>Temp Converter Pure JSP</h2>
	<br>
	<div style="width: 50%">
		<div style="width: 50%; border: 1px dotted red;">
			<c:choose>
				<c:when test="${param.degree_type == 'F'}">
					<c:out value="${param.degree_value}" />F is 
					<fmt:formatNumber var="c_temp" maxFractionDigits="2">
                        ${(param.degree_value - 32)*5./9.}
					</fmt:formatNumber>  
					<c:out value="${c_temp}"/>C
                </c:when>
				<c:when test="${param.degree_type == 'C'}">
					<c:out value="${param.degree_value}" />C is 
					<fmt:formatNumber var="f_temp" maxFractionDigits="2">
					    ${(param.degree_value*9./5.) + 32} 
					</fmt:formatNumber>  
					<c:out value="${f_temp}"/>F
                </c:when>
				<c:otherwise>
    Waiting for valid temperature
  </c:otherwise>
			</c:choose>
		</div>
		<br>
		<form action="temp_converter_standalone.jsp" method="POST">
			<div id="table">
				<div class="row">
					<span class="cell"> Input temp type (C or F) </span> <span
						class="cell"> <input id="degree_type" type="text"
						name="degree_type" value="${param.degree_type}">
					</span>
				</div>
				<div class="row">
					<span class="cell"> Input degrees</span> <span class="cell">
						<input id="degree_value" type="text" name="degree_value"
						value="${param.degree_value}">
					</span>
				</div>
			</div>
			<br>
			<input type="submit">
		</form>
	</div>
</body>
</html>