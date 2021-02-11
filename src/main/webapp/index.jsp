<%@include file="header.jsp"%>
 <%@page import="java.util.List"%>
<%@page import="com.cybage.model.Category"%> 
	<div class="mySpace"></div>
	<div class="text-center mt-5"><h1>Welcome to Cybage-E-Learning Portal</h1></div>
	<section class="mb-5">
		<div class="jumbotron bg-light container-fluid px-3 py-3">
			<div id="carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="img-fluid w-100"
							src="<%=request.getContextPath()%>/images/cor1.png"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="img-fluid w-100"
							src="<%=request.getContextPath()%>/images/cor2.png"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="img-fluid w-100"
							src="<%=request.getContextPath()%>/images/cor3.png"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carousel" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
			<h3>
				<strong>Knowledge is now, just a click away!</strong>
			</h3>
			<p class="lead">Welcome to the e-learning portal of Cybage. This
				portal ensures the best of the courses in the number of categories
				across the globe.</p>

		</div>
		<div class="jumbotron bg-light container-fluid mt-5 px-3 py-3">
			<h3>
				<strong>Our Categories</strong>
			</h3>
			<p class="lead">The users find these categories most-interacting.
				have fun exploring!</p>
				
			<div class="card-group m-3">

				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 1</h5>
						<p class="card-text">Description on category 1</p>
						<p class="card-text">
							<small class="text-muted">Oxford University, UK</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>

				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 2</h5>
						<p class="card-text">Description on category 2</p>
						<p class="card-text">
							<small class="text-muted">California University, USA</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>
				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 3</h5>
						<p class="card-text">Description on category 3</p>
						<p class="card-text">
							<small class="text-muted">GTU, India</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>
			</div>

			<div class="card-group">
				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 4</h5>
						<p class="card-text">Description on category 4</p>
						<p class="card-text">
							<small class="text-muted">Oxford University, UK</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>
				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 5</h5>
						<p class="card-text">Description on category 5</p>
						<p class="card-text">
							<small class="text-muted">California University, USA</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>
				<div class="card m-3">
					<img src="<%=request.getContextPath()%>/images/motivation.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Category 6</h5>
						<p class="card-text">Description on category 6</p>
						<p class="card-text">
							<small class="text-muted">GTU, India</small>
						</p>
						<a class="btn btn-outline-dark btn-lg" href="<%=request.getContextPath()%>/AppController/login" role="button">Explore
							more</a>
					</div>
				</div>
			</div>

		</div>
		<figure class="text-center mt-5">
			<blockquote class="blockquote">
				<p>Our approach is a matter of a choice. Our motive, however, is
					a matter of our character.</p>
			</blockquote>
			<figcaption class="blockquote-footer">
				<cite title="Source Title">Arun Nathani</cite>, Cybage
			</figcaption>
		</figure>
	</section>
<%@include file="footer.jsp"%>	


