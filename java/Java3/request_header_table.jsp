<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>${my_name} </title>
</head><body>
<div class="container-fluid">
<h2>Some Request Headers by ${my_name}</h2>
<table class="table table-hover">
<thead>
<tr><th>Key</th><th>Value</th></tr>
</thead>
<tbody>
<tr><td>host</td><td>${host}</td></tr>
<tr><td>user-agent</td><td>${user_agent}</td></tr>
<tr><td>accept</td><td>${accept}</td></tr>
</tbody>
</table>
</div>
</body></html>