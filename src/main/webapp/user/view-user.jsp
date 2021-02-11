<%@page import="com.cybage.model.User"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>


<h1>welcome <%= request.getRemoteUser()  %></h1>
<a href="<%=request.getContextPath()%>/user/add-user.jsp">Add User</a>
<br>
<table border="1">
	<tr>
		<td>User id</td>
		<td>Username</td>
		<td>Address</td>
		<td>Role</td>
		<td><a href="#">Update</a></td>
		<td><a href="#">Delete</a></td>
	</tr>

	<c:forEach var="u" items="${users}">
		<tr>
			<td><c:out value="${u.id }"></c:out></td>
			<td><c:out value="${u.name }"></c:out></td>
			<td><c:out value="${u.address }"></c:out></td>
			<td><c:out value="${u.role }"></c:out></td>
			<td><a href="<%=request.getContextPath() %>/UserController/edit?id=${u.id}">Update</a></td>
			<td><a href="<%=request.getContextPath() %>/UserController/delete?id=${u.id}">Delete</a></td>
		</tr>
	</c:forEach>

	<%-- <%
		List<User> users = (List) request.getAttribute("users");
		for (User u : users) {
			out.print("<tr>");
			out.print("<td>" + u.getId() + "</td>");
			out.print("<td>" + u.getName() + "</td>");
			out.print("<td>" + u.getAddress() + "</td>");

			/* String delurl = "<td><a href="+request.getContextPath()+"/UserController/delete?id="+u.getId()+">Delete</a></td>";
			String updateurl = "<td><a href="+request.getContextPath()+"/UserController/edit?id="+u.getId()+">update</a></td>";
			out.print(updateurl);
			out.print(delurl); */
			out.print("<tr>");
		}
	%> --%>

</table>


<%@include file="footer.jsp"%>