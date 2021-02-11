<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="header.jsp"%>
<div class="container myContainer">
<div class="row">
<div class="col-lg-12">
<h1>Add Category</h1>
<form action="<%=request.getContextPath() %>/AdminController/add_category" method="post"  enctype="multipart/form-data" border="1">
	<div class="row"><div class="col-lg-2">Category_name:</div>
	 <div class="col-lg-8"><input type="text" name="cname"></div>
	 </div>
	<br>
	<div class="row">
	<div class="col-lg-2">Category-Image</div>
	
	<div class="col-lg-8"> <input type="file" name="cimage" size="500"></div>
	</div>
	
	<br>
	
	<div class="col-lg-8"> <input type="submit" value="Add Category"></div>
	
</form>
</div>
</div>
</div>

<%@include file="footer.jsp"%>