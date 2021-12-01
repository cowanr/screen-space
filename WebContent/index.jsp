<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<%@include file="components/common_css_js.jsp"%>

	<title>Screenspace</title>
</head>

<script>
	function validateform() {
		var uname = document.myform.uname.value;
		var pass = document.myform.pass.value;
		var email = document.myform.email.value;
		var phone = document.myform.phone.value;

		if (uname == null || uname == "") {
			alert("Username can't be left blank!");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be left blank!");
			return false;
		} else if (pass == null || pass == "") {
			alert("Password can't be left blank!");
			return false;
		} else if (phone == null || phone == "") {
			alert("Phone can't be left blank!");
			return false;
		}

	}
</script>

<body>

<%@include file="components/navbar.jsp"%>


<div style="max-height: 760px" class=" container-fluid mt-5">
	<div class="row ml-5 mt-5">
		<div class="bg-white mt-5  col-8">

			<div class="row ml-5">
				<h2>Transform your screens into powerful digital signs..</h2>
				<img class="ml-5" src="images/illustration.png"
					 style="width: 75%; height: 75%">
			</div>
			<hr>
			<div class="row ml-5">

				<div class="row">
					<div class="col-4">

						<img class="ml-5" src="images/thumb1.png"
							 style="width: 75%; height: 75%">

					</div>
					<div class="col-4">

						<img class="ml-5" src="images/thumb2.png"
							 style="width: 75%; height: 75%">

					</div>

					<div class="col-4">

						<img class="ml-5" src="images/thumb3.png"
							 style="width: 75%; height: 75%">

					</div>
				</div>
			</div>


		</div>

		<div class="col-4 mt-4">
			<div style="min-height: 680px" class="card mr-5">
				<div class="card-body px-5">

					<h3 class="text-center mt-2">Welcome to Screenspace!</h3>

					<form name="myform" method="post" action="signupController"
						  onsubmit="return validateform()">
						<br />
						<div class="form-group">
							<%String uname = (String) request.getAttribute("uname"); %>
							<label for="uname">Username:</label> <input name="uname"
																		type="text" value="<c:if test="${not empty uname}"><%=uname%></c:if>" class="form-control" id="uname"
																		aria-describedby="unameHelp" placeholder="Enter Username">
							<%String uname_error = (String) request.getAttribute("uname_error"); %>
							<c:if test="${not empty uname_error}">
								<br />
								<div class="alert alert-danger alert-dismissible fade show">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									The username must be alphanumeric between 8 to 20 characters long.
								</div>
							</c:if>
						</div>

						<div class="form-group">
							<%String email = (String) request.getAttribute("email"); %>
							<label for="email">Email Address:</label> <input name="email"
																			 type="email" value="<c:if test="${not empty email}"><%=email%></c:if>" class="form-control" id="email"
																			 aria-describedby="emailHelp" placeholder="Enter Email Address">
							<%String email_error = (String) request.getAttribute("email_error"); %>
							<c:if test="${not empty email_error}">
								<br />
								<div class="alert alert-danger alert-dismissible fade show">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									The email must be valid.
								</div>
							</c:if>
						</div>

						<div class="form-group">
							<%String pass = (String) request.getAttribute("pass"); %>
							<label for="pass">Password:</label> <input name="pass"
																	   type="password" value="<c:if test="${not empty pass}"><%=pass%></c:if>" class="form-control" id="pass"
																	   aria-describedby="passHelp" placeholder="Enter Password">
							<%String pass_error = (String) request.getAttribute("pass_error"); %>
							<c:if test="${not empty pass_error}">
								<br />
								<div class="alert alert-danger alert-dismissible fade show">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									The password must be alphanumeric between 8 to 20 characters long.
								</div>
							</c:if>
						</div>

						<div class="form-group">
							<%String phone = (String) request.getAttribute("phone"); %>
							<label for="phone">Phone number:</label> <input name="phone"
																			type="text" class="form-control" id="phone"
																			aria-describedby="phoneHelp" value="<c:if test="${not empty phone}"><%=phone%></c:if>" placeholder="Enter Phone Number">
							<%String phone_error = (String) request.getAttribute("phone_error"); %>
							<c:if test="${not empty phone_error}">
								<br />
								<div class="alert alert-danger alert-dismissible fade show">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									The phone must be a 10 digit number.
								</div>
							</c:if>
						</div>



						<br />
						<div class="container text-center">
							<input class="btn btn-dark" type="submit" value="Sign Up">
							<a class="btn btn-outline-primary" href="login.jsp">Login</a>
							<hr><p>If you already have an account, please click login above.</p>
						</div>



					</form>


				</div>


			</div>



		</div>

	</div>


</div>
<nav class="navbar fixed-bottom navbar-dark bg-dark mt-5">
	<div class="container-fluid justify-content-center">
		<a class="navbar-brand bg-dark" href="#">Created at: Carleton University &COPY;  </a>
	</div>
</nav>
</body>
</html>