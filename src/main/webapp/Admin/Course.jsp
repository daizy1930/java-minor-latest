<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@include file="header.jsp"%>
<script>
	var flag = 0;
	function fin(a) {
		if (flag == 0) {
			document.getElementsByClassName(a)[0].disabled = false;
			document.getElementsByClassName(a)[1].disabled = false;

			//alert("content editable");
			flag = 1;
			return false;

		} else {
			flag = 0;
			return true;
		}

	}
</script>

<h1>
	welcome
	<%=request.getRemoteUser()%></h1>
<div class="mt-5"></div>
<div class ="container">
	<div class="row">
		<div class="col-lg-12 mt-4">
			<a href="<%=request.getContextPath()%>/AdminController/Course_getway" class="btn btn-primary float-end">Add Course</a>
		</div>
	</div>
</div>


<br>
<div class="container">
	<div class ="row">
		
		<div class="col-lg-12">
			
		  <table border="1" class="table">
			<thead class="bg-info text-white">
				<tr>
					<td></td>
					<td>Course name</td>
					<td>Course Description</td>
					<td>Course image</td>
					<td>Choose new file</td>
					<td>Category name</td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${courses}">
				
				<tr>
					<form enctype="multipart/form-data" method="post" onsubmit="return fin('${u.id}')" action=<%= request.getContextPath()%> /AdminController/update_course>
					
						<td><input type="text" value="${u.id}" hidden name="course_id"></td>
						
						<td><input type"text" value="${u.name }" disabled class="${u.id }" name="course_name"></td>
							
						<td><input type"text" value="${u.desc }" disabled class="${u.id }" name="course_desc"></td>
							
						<td><input type="image" src="data:image/jpeg;base64,${u.encode}" height="100px"></td>
							
						<td><input type="file" name="image" class="${u.id }"></td>
						
						<td><input type"text" value="${u.category }" disabled></td>
						
						<td><input type="submit" value="Edit" class="btn btn-primary"></td>
						
						<td><a
							href="<%=request.getContextPath() %>/AdminController/delete_course?id=${u.id}"
							onclick="return window.confirm('Are you sure')" class="btn btn-danger">Delete</a></td>
							
					
					</form>
				</tr>
			</c:forEach>
			
			</tbody>

		</table>
			
		</div>
	

</div>
<%@include file="footer.jsp"%>



