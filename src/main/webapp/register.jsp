<%@include file="header.jsp"%>
<div class="mySpace"></div>
<form method="POST"
	action="<%=request.getContextPath()%>/UserController/reg" method="post">
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-column my-5">
					<div class="card-header text-center h1">Registration</div>
					<div class="card-body">
						<form class="form-signin">
							<div class="form-label-group mt-3">
								Name: <input type="text" name="name" class="form-control"
									placeholder="John" required autofocus>
							</div>
							<div class="form-label-group mt-3">
								Userame: <input type="text" name="username" class="form-control"
									placeholder="john123" required autofocus>
							</div>
							<div class="form-label-group mt-3">
								Email: <input type="email" name="email" class="form-control"
									placeholder="john123@xyz.com" required autofocus>
							</div>


							<div class="form-label-group mt-3">
								Password: <input type="password" name="password"
									class="form-control" placeholder="***" required>
							</div>

							<div class="text-center mt-3">
								<button class="btn btn-info btn-block text-white text-center"
									type="submit">Register</button>
							</div>
							<div class="text-center mt-3">
								<a href="<%=request.getContextPath()%>/AppController/login">Already
									a user? Login here</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<%@include file="footer.jsp"%>