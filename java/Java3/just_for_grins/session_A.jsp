<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head><body>
<div class="container-fluid">
<h3>Session id ${id}
<br>New session? ${isNew} 
<br>Cookies:
<% 
// demonstrates the "old" way of doing things just for grins!
// today JSTL and EL only are used for best practices

Cookie[] cookies = request.getCookies();
if (cookies == null) {
%>
	Sorry, no cookies
<% 
    }
else {
%>
<table class="table table-hover">
<% 
for (Cookie next_cookie : cookies) { %>
  <tr>
    <td><%= next_cookie.getName() %></td>
    <td><%= next_cookie.getValue() %></td>
  </tr>
<% 
    } 
 } 
 %>
</table></h3>

</body>
</html>