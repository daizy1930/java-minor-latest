<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:green;">logout</h2>
<%
session.invalidate();
%>
<jsp:include page="index.jsp"></jsp:include>
</body>
</html>