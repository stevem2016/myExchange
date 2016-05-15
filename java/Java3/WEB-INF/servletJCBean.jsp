<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>`

<!DOCTYPE html><html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head><body>
<div class="container-fluid">

<h2>id=${id}</h2>
<h2>isNew=${isNew}</h2>

<h2>All returning cookies...</h2>
<table class="table table-hover">
<thead>
<tr><th>Key</th><th>Value</th></tr>
</thead>
<tbody>
<c:forEach var="next" items="${cc}">
	<tr><td>${next.name}</td><td>${next.value}</td></tr>
</c:forEach>
</tbody>
</table>
</div>
</body></html>