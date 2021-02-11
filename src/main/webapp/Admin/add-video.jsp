<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<%@include file = "header.jsp" %>



<div class="container myContainer">
	<div class="row">
		<div class="col-lg-12">
			<h1>Add Video</h1>
		</div>
	</div>
	<div class=" px-5 py-5 " style="border: 1px solid black;">
	<form action="<%=request.getContextPath() %>/AdminController/add_video" method="post"  enctype="multipart/form-data">
	<div class="row">
		<div class="col-lg-2">Select Course: </div>
		<div class="col-lg-8"><select name="course" value="Select Course" required>
			<c:forEach var="u" items="${courses}">
	
				<option value="${u.id }" >${u.name }</option>
				
			</c:forEach>
			</select>
		
		</div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Video Name:</div>
		<div class="col-lg-8"><input type="text" name="vname" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Video Duration:</div>
		<div class="col-lg-8"> <input type="number" name="duration" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-2">Video Location:</div>
		<div class="col-lg-8"><input type="text" name="video_url" required></div>
	</div><br>
	
	<div class="row">
		<div class="col-lg-12"><input type="submit" value="Add course" class="btn btn-primary"></div>
	</div>
	
	</form>
	</div>
</div>


<%@include file = "footer.jsp" %>