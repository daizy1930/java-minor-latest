<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file = "header.jsp" %>



<div class="container myContainer">
	<div class="row">
		<div class="col-lg-12">
			<h1>Add Course</h1>
		</div>
	</div>
	<div class=" px-5 py-5 " style="border: 1px solid black;">
	<form action="<%=request.getContextPath() %>/AdminController/add_course" method="post"  enctype="multipart/form-data">
	<div class="row">
		<div class="col-lg-2">Select Category: </div>
		<div class="col-lg-8"><select name="category" value="Select Category" required>
			<c:forEach var="u" items="${categories}">
	
				<option value="${u.id }" >${u.name }</option>
				
			</c:forEach>
			</select>
		
		</div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Course Name:</div>
		<div class="col-lg-8"><input type="text" name="cname" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Course Description:</div>
		<div class="col-lg-8"><input type="text" name="cdesc" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Course Image:</div>
		<div class="col-lg-8"><input type="file" name="cimage" size="500" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-12"><input type="submit" value="Add course" class="btn btn-primary"></div>
	</div>
	
	</form>
	</div>
</div>


<%@include file = "footer.jsp" %>