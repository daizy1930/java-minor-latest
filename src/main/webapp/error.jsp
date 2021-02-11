<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage= "true" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
        <h1>Error</h1>
        <h2 > Error: <%=exception.getClass().getName() %><br/>
    <%=exception.getMessage() %><br/>  
  </h2>
</body>
</html>



 





