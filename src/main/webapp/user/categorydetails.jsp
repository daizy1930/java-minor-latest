<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="mySpace">
<!-- here category name -->
	<% int n=0; %>
	<h2 class="category">Category name</h2> 
	<c:forEach var="u" items="${course}">
		<!-- card -->
		<div class="card-group">
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="${u.course_image}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${u.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/start-course">
	        	<input type="hidden" value="${u.id}" name="course_id">
	        	<input type="submit" value="Enroll now" class="btn btn-primary mycard">
	        </form>
	       <%--  <a href="<%=request.getContextPath()%>/UserController/start-course" class="btn btn-primary mycard">Enroll now</a> --%>
	        <%-- <c:if test=""></c:if> --%>
	        <%-- <% session.setAttribute("${u.name}", "+${u.id}+"); %>  --%>
	      <%-- 	<c:set var="<%=n%>" value="${u.id}" scope="session" />  --%>
			<c:set var="course_name" value="${u.name}" scope="session" />
	      </div>
	    </div>
	    </div>
	</c:forEach>
	
	
	</div>
	
	<div class="mySpace"></div>
<%@include file="footer.jsp" %>