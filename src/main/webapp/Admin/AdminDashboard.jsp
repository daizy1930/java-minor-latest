<%@include file="header.jsp"%>

<div class="myContainer"></div>

<div class="container my-5 ">
	<div class="float-left">
		<h2>Welcome,
		<%=request.getRemoteUser()%>!</h2>
	</div>
	<div class="row row-cols-1 row-cols-md-3 g-4 my-5 ">
		<div class="col">
			<a
				href="<%=request.getContextPath()%>/AdminController/fetch_category"
				class="cardsDashboard">
				<div class="card">
					<img src="<%=request.getContextPath()%>/images/baground.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h2 class="card-title text-center text-primary">CATEGORIES</h2>

					</div>
				</div>
			</a>
		</div>
		<div class="col">
			<a href="<%=request.getContextPath()%>/AdminController/fetch"
				class="cardsDashboard">
				<div class="card">
					<img src="<%=request.getContextPath()%>/images/courses_card.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h2 class="card-title text-center text-primary">COURSES</h2>

					</div>
				</div>
			</a>
		</div>
		<div class="col">
			<a href="<%=request.getContextPath()%>/AdminController/fetch_video"
				class="cardsDashboard">
				<div class="card">
					<img src="<%=request.getContextPath()%>/images/video_card.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h2 class="card-title text-center text-primary">VIDEOS</h2>

					</div>
				</div>
			</a>
		</div>

	</div>



</div>

<%@include file="footer.jsp"%>