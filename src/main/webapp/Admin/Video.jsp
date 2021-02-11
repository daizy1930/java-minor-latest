<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@include file = "header.jsp" %>
<script>
var flag=0;
function fin(a) {
	if(flag==0){
		document.getElementsByClassName(a)[0].disabled=false;
		document.getElementsByClassName(a)[1].disabled=false;
		document.getElementsByClassName(a)[2].disabled=false;
		document.getElementsByClassName(a)[3].disabled=false;
		
		flag=1;
		return false;	
		

	}
	else{
		flag=0;
		return true;
	}
}

</script>
<h1>welcome <%= request.getRemoteUser()  %></h1>

<br>

<div class="mt-5"></div>
<div class ="container">
	<div class="row">
		<div class="col-lg-12 mt-4">
			<a href="<%=request.getContextPath()%>/AdminController/Video_getway" class="btn btn-primary float-end">Add video</a>
		</div>
	</div>
</div>
<br>

<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<table border="1" class="table">
			<thead class="bg-info text-white">
				<tr>
					<td>Video Name</td>
					<td>Video url</td>
				
					<td>Video duration</td>
					<td>Course Name</td>
					<td>Update</td>
					<td>Delete</td>
					
				</tr>
				
			</thead>
			<tbody>

			<c:forEach var="u" items="${videos}">
				<tr>
					<td><form method="post" onsubmit="return fin('${u.name}')" action=<%= request.getContextPath()%>/AdminController/update_video ><input type="text" value="${u.name }" disabled class="${u.name }" name="videoname"></td>
					
					<td><input type="text" value="${u.url }" disabled class="${u.name }" name="url"></td>
					
					<td><input type="text" value="${u.duration}" disabled class="${u.name }" name="duration"></td>
					
					<td><input type="text" value="${u.course }" disabled ></td>
					
					<td><input type="submit" value="Edit" class="btn btn-primary"></td>
					
					<input type="text" value="${u.id}" disabled class="${u.name }" name="id" hidden></form>
					
					<td><a href="<%=request.getContextPath() %>/AdminController/delete_video?id=${u.id}" onclick="return window.confirm('Are you sure')" class="btn btn-danger">Delete</a></td>
			
				</tr>
			</c:forEach>
			</tbody>
			
		</table>
		
		</div>
	</div>
</div>

<%@include file = "footer.jsp" %>