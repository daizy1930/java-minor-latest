<%@include file="header.jsp"%>
<div class="mySpace"></div>
	<form method="POST" action="j_security_check">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-9 mx-auto">
					<div class="card card-signin flex-column my-5">
						<div class="card-header text-center h1">Login</div>
						<div class="card-body">
							<h5 class="card-title text-center btn-info text-white rounded">Welcome
								back!</h5>
							<form class="form-signin">
								<div class="form-label-group mt-3">
									Username: <input type="text" name="j_username"
										class="form-control" placeholder="user" required autofocus>
								</div>


								<div class="form-label-group mt-3">
									Password: <input type="password" name="j_password"
										class="form-control" placeholder="***" required>

								</div>


								<div class="text-center mt-3">
									<button class="btn btn-info btn-block text-white text-center"
										type="submit">Sign In</button>
								</div>
								<div class="text-center mt-3">
									<a href="<%=request.getContextPath()%>/register.jsp">Not a
										user? Register here</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@include file="footer.jsp"%>