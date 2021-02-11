<%@include file="header.jsp"%>
<div class="mySpace"></div>
<div class="alert alert-success text-center" role="alert">
  <h2><strong>Logout successful</strong></h2>
</div>
<%
session.invalidate();
%>
<jsp:include page="index.jsp"></jsp:include>
<%@include file="footer.jsp"%>