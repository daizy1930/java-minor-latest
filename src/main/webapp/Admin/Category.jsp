<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@include file="header.jsp"%>
<script>
	var flag = 0;
	function fin(a) {
		if (flag == 0) {
			document.getElementsByClassName(a)[0].disabled = false;

			flag = 1;
			return false;

		} else {
			flag = 0;
			return true;
		}

	}
</script>

<div class="container-fluid mt-5 ">
	<h1>
		welcome
		<%=request.getRemoteUser()%></h1>
</div>

<br>

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-4 ps-5">
			<h1>Add Category</h1>
			<div class=" px-5 py-5 " style="border: 1px solid black;">
			
				<form action="<%=request.getContextPath()%>/AdminController/add_category" method="post" enctype="multipart/form-data">
				
					<div class="row">
						<div class="col-lg-4">Category_name:</div>
						
						<div class="col-lg-8">
							<input type="text" name="cname">
						</div>
					</div>
					<br>
					
					<div class="row">
						<div class="col-lg-4">Category-Image</div>

						<div class="col-lg-8">
							<input type="file" name="cimage" size="500">
						</div>
					</div>
					<br>

					<div class="col-lg-8">
						<input type="submit" value="Add Category" class="btn btn-primary">
					</div>

				</form>
			</div>
		</div>
		
		<div class="col-lg-8">
			<table border="1" class="table">
				<thead class="bg-info text-white">
					<tr>
						<td>Category Name</td>
						<td>Category Image</td>
						<td>Select Image to be updated</td>
						<td>Update</td>
						<td>Delete</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="u" items="${categories}">
						<tr>
							<td><form enctype="multipart/form-data" method="post" onsubmit="return fin('${u.name}')" action=<%= request.getContextPath()%>/AdminController/update_category>
									<input type="text" value="${u.name }" disabled class="${u.name }" name="name"></td>
									
							<td><input type="text" name="id" value="${u.id }" hidden>
							
								<input type="image" src="data:image/jpeg;base64,${u.encode}" height="100px" alt="not available right now"></td>
								
							<td><input type="file" name="image" class="${u.id }"></td>

							<td><input type="submit" class="btn btn-primary" value="Edit"></td>
					
							</form>

							
							<td><a href="<%=request.getContextPath() %>/AdminController/delete_category?id=${u.id}" onclick="return window.confirm('Are you sure')" class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</div>


<%@include file="footer.jsp"%>