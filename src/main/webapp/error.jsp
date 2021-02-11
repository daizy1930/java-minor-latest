<%@include file="header.jsp"%>
<%@ page isErrorPage="true"%>
<div class="mySpace"></div>
<div class="alert alert-danger text-center" role="alert">
	<h2>
		<strong>Error!</strong>
	</h2>
	<h2>
		Error:
		<%=exception.getClass().getName()%><br />
		<%=exception.getLocalizedMessage()%><br />
	</h2>
</div>
<jsp:include page="index.jsp"></jsp:include>
<%@include file="footer.jsp"%>








