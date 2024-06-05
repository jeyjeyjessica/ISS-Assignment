<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form</title>


<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"> 

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="POST" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="email"></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required="required" />
							</div>
							<div class="form-group">
								<label for="pass"></label> <input
									type="password" name="pass" id="pass" placeholder="Password" required="required" />
							</div>
							<div class="form-group">
								<label for="re-pass"></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Confirm password" required="required"/>
							</div>
							<div class="form-group">
								<label for="contact"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact number" required="required"/>
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sign up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
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
document.getElementById("register-form").addEventListener("submit", function(event) {
	var name = document.getElementById("name").value.trim();
    var email = document.getElementById("email").value.trim();
    var pass = document.getElementById("pass").value.trim();
    var re_pass = document.getElementById("re_pass").value.trim();
    var contact = document.getElementById("contact").value.trim();
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!name || !email || !pass || !re_pass || !contact) {
        event.preventDefault();
        swal("Error", "Please fill all the details", "error");
        return false;
    }

    if (!emailPattern.test(email)) {
        event.preventDefault();
        swal("Error", "Please enter a valid email address", "error");
        return false;
    }

    if (pass.length < 6) {
        event.preventDefault();
        swal("Error", "Password must be at least 6 characters long", "error");
        return false;
    }

    if (pass !== re_pass) {
        event.preventDefault();
        swal("Error", "Password and Confirm Password do not match", "error");
        return false;
    }
    
    if (!document.getElementById("agree-term").checked) {
        event.preventDefault();
        swal("Error", "You must agree to the terms of service", "error");
        return false;
    }

    return true;
});
	
	var status = document.getElementById("status").value;
	if(status=="success"){
		swal("Congratulations","Account created successfully","success");
	}
	if(status=="invalidName"){
		swal("Error","Please enter name","error");
	}
	if(status=="invalidPassword"){
		swal("Error","Please enter password","error");
	}
	if(status=="invalidEmail"){
		swal("Error","Please enter proper email","error");
	}
	if(status=="invalidMobile"){
		swal("Error","Please enter contact details","error");
	}
	if(status=="invalidMobileLength"){
		swal("Error","Mobile number should be of 10 digits","error");
	}
	if(status=="invalidPasswordConfirm"){
		swal("Error","Password and Confirm Password donot match","error");
	}
	
	</script>



</body>

</html>