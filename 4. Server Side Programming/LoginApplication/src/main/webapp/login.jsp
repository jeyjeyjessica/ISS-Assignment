
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In Form</title>


<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"> 
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign In</h2>
						<form method="POST" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"></label> <input
									type="email" name="email" id="email"
									placeholder="Enter email" required="required" /> 
							</div>
							<div class="form-group">
								<label for="password"></label> <input
									type="password" name="password" id="password"
									placeholder="Password" required="required" />
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status=="failed"){
		swal("Login Failed","Please check email and password once again","error");
	}
<!-- If someone bypasses the client side validation using inspect. so server side validation is added -->
else if(status=="invalidEmail"){
		swal("Login Failed","Please enter email","error");
	}
else if(status=="invalidPassword"){
		swal("Login Failed","Please enter password","error");
	}
	
	</script>

	
</body>

</html>