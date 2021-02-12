<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="mySpace">

<div class="topnav">
  <div class="search-container">
    <form action="<%=request.getContextPath()%>/UserController/search">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
 <c:if test = "${searchresult == 0}">
 	<a href="<%=request.getContextPath()%>/UserController/main">Go Back</a>
 </c:if>
 <c:if test = "${searchedcategories == null}">
	<c:forEach var="u" items="${allCategories}">
			<!-- card -->
		    <div class="card" style="width:400px">
		      <img class="card-img-top" src="data:image/jpeg;base64,${u.encode}" alt="Card image" style="width:100%">
		      <div class="card-body">
		        <h4 class="card-title"><c:out value="${u.name}"></c:out></h4>
		        <form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
					<input type="hidden" value="${u.id}" name="category_id">
					<input type="hidden" value="${u.name}" name="category_name">
					<input type="submit" value="Explore more" class="btn btn-primary">
				</form>
		      </div>
		    </div>
	</c:forEach>
 </c:if>
 <c:if test = "${searchedcategories != null}">
 	<c:forEach var="s" items="${searchedcategories}">
			<!-- card -->
		    <div class="card" style="width:400px">
		      <img class="card-img-top" src="${s.category_url}" alt="Card image" style="width:100%">
		      <div class="card-body">
		        <h4 class="card-title"><c:out value="${s.name}"></c:out></h4>
		        <form action="<%=request.getContextPath()%>/UserController/show-courses" method="post">
					<input type="hidden" value="${s.id}" name="category_id">
					<input type="hidden" value="${s.name}" name="category_name">
					<input type="submit" value="Explore more" class="btn btn-primary">
				</form>
		      </div>
		    </div>
	</c:forEach>
 </c:if>
 
 </div>

 <div class="mySpace"></div>
 <%@include file="footer.jsp" %>