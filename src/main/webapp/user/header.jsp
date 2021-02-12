<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cybage E-Learning</title>
    <!-- site icon -->
    <link href="<%=request.getContextPath() %>/images/Cybage-e-learning.ico" rel="icon" />
    
    <link rel ="stylesheet" href = "<%=request.getContextPath() %>/css/main.css">

	 <!-- bootstrap min css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous"/>
    <!-- all css -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    

    <!-- bootstrap min js -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>

<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container-fluid">
		  <a class="navbar-brand" href="<%=request.getContextPath()%>/Admin/AdminDashboard.jsp">
            <img src="<%=request.getContextPath() %>/images/Cybage-e-learning-logo.png" class="image-fluid imgLogo" /> </a>
			

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarTogglerDemo01">
				<ul class="navbar-nav mr-auto mb-2 mb-lg-0">
					
					
						
						<li class="nav-item"><a class="nav-link mx-2"
						href="<%= request.getContextPath()%>/AdminController/fetch"><i class="fas fa-graduation-cap me-2"></i>Enroll Course</a></li>
						

					<form class="d-flex">
						<a href="<%=request.getContextPath()%>/logout.jsp" class="btn btn-outline-info my-2 my-sm-0 float-end">Logout</a>
					</form>
				</ul>
			</div>
		</div>
	</nav>
	</header>
