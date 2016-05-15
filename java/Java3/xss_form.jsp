<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Notice we call JSP directly so will need to use implicit variables -->
  <form action="xss.jsp" method="POST">
    <input type="text" name="first" value="first"><br>
    <input type="text" name="last" value="last"><br>
    <input type="submit">
  </form>

</body>
</html>