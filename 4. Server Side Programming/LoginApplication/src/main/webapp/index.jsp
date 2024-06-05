<%

if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .content {
            text-align: center;
        }
        .welcome-text {
            color: darkblue;
            font-size: 3rem;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .logout-btn {
            font-size: 1.5rem;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="content">
       
        <div class="welcome-text">Welcome to this page <%= session.getAttribute("name") %></div>
        <a href="logout" class="btn btn-danger logout-btn">Logout</a>
        
    </div>

    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>

