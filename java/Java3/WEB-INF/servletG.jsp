<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html><html lang="en">
<head>
<meta charset="utf-8">
<c:if test="${binky.host == 'localhost:8080'}">
<h2>Local host so add Bootstrap formatting (just an example)</h2>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</c:if>
</head><body>
<c:import url="/header.html" />
<div class="container-fluid">
<table class="table table-hover">
<thead>
<tr><th>Key</th><th>Value</th></tr>
</thead>
<tbody>
<tr><td>host</td><td>${binky.host}</td></tr>
<jsp:useBean id="binky" class="edu.acc.java.HeaderBean" scope="request"></jsp:useBean>
<tr><td>host</td><td><jsp:getProperty name="binky" property="host"/></td></tr>
<tr><td>user-agent</td><td>${binky.userAgent}</td></tr>
<tr><td>user-agent</td><td><jsp:getProperty name="binky" property="userAgent"/></td></tr>
<tr><td>accept</td><td>${binky.accept}</td></tr>
<tr><td>accept</td><td><jsp:getProperty name="binky" property="accept"/></td></tr>
</tbody>
</table>
</div>
<c:import url="/footer.jsp" />
</body></html>