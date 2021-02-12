<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="mySpace">
<div class="container">
	<h2 class="category"><%=request.getParameter("category_name") %></h2> 
	<c:forEach var="n" items="${completed}">
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="data:image/jpeg;base64,${n.encode}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${n.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${n.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/pdf-complete" method="post">
	        	<input type="hidden" value="${n.id}" name="course_id">
	        	<input type="hidden" value="${n.name}" name="course_name">
	        	<input type="submit" value="Completed" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	</c:forEach>
	<c:forEach var="u" items="${enrolledcourse}">
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="data:image/jpeg;base64,${u.encode}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${u.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/continue-course" method="post">
	        	<input type="hidden" value="${u.id}" name="course_id">
	        	<input type="hidden" value="${u.name}" name="course_name">
	        	<input type="submit" value="Continue" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	</c:forEach>
	<c:forEach var="n" items="${newcourse}">
		<!-- card -->
	    <div class="card" style="width:400px">
	      <img class="card-img-top" src="data:image/jpeg;base64,${n.encode}" alt="Card image" style="width:100%">
	      <div class="card-body">
	        <h4 class="card-title"><c:out value="${n.name}"></c:out></h4>
	        <p class="card-text"><c:out value="${n.desc}"></c:out></p>
	        <form action="<%=request.getContextPath()%>/UserController/start-course" method="post">
	        	<input type="hidden" value="${n.id}" name="course_id">
	        	<input type="hidden" value="${n.name}" name="course_name">
	        	<input type="submit" value="Enroll Now" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	</c:forEach>
	 </div>
	
	</div>
	
	</div>
	
	<div class="mySpace"></div>
<%@include file="footer.jsp" %>