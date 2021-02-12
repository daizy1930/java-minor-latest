<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.cybage.model.Video" %>
<%@page isELIgnored="false" %>
<%@include file="header.jsp" %>
<script type="text/javascript">
function next(a,b,length) {
	var course_name=document.getElementById("course_name").value;
	var id=document.getElementById("video_id").value;
	if(a==(length-1)){
		window.location="http://localhost:8081/jsp-example/UserController/completed_course?course_name="+course_name+"&video_id="+id;
	}
	
	
	var video=document.getElementById(a);
	var label=document.getElementById(a+1);
	
	video.setAttribute("src","../Video/"+label.getAttribute("value"));
	video.setAttribute("id",a+1);
	
	var c=a+1;
	b.setAttribute("onclick","next("+c+",this,"+length+")");

}


</script>
<%@include file="header.jsp" %>

<div class="mySpace">
<div class="container">
<video src="../Video/${video.get(0).url}" width="500" height="500" controls="controls" id="${video.indexOf(u)+1}"></video>
<button class="btn btn-warning"><i class="fas fa-arrow-left" ></i></button>
<%-- <button id="${video.indexOf(u)+1}" onclick="next(${video.indexOf(u)+1},this,${video.size()})">Next</button> --%>
<button id="${video.indexOf(u)+1}" onclick="next(${video.indexOf(u)+1},this,${video.size()})" class="btn btn-primary"><i class="fas fa-arrow-right" ></i></button>
<input type="hidden" id="course_name" value="${video.get(0).course}"></input> 
<input type="hidden" id="video_id" value="${video.get(0).id}"></input> 
<%-- </c:forEach> --%>
 <c:forEach var="u" items="${video}" >
 <label hidden id="${video.indexOf(u)}" value="${u.url}"></label> 
 
</c:forEach>

</div>
</div>

<div class="mySpace"></div>
<%@include file="footer.jsp" %>