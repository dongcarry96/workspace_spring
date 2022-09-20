<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
<%
	Cookie cook1 = new Cookie("notebook","");
	cook1.setMaxAge(0);
	response.addCookie(cook1);
%>
</body>
</html>