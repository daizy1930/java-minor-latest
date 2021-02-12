<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="mySpace">
	 <embed src="../Video/<%= request.getAttribute("pdf-loc") %>.pdf
	 " width="500px" height="500px"> 
	<a href="<%=request.getContextPath()%>/UserController/main">go back to home</a>
	 
</div>

<div class="mySpace"></div>
<%@include file="footer.jsp" %>