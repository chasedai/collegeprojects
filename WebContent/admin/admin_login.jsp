<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../themes/assets/ico/favicon.ico">
<title>Athlone IT's Take Away</title>

<!-- Bootstrap core CSS -->
<link href="../themes/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="themes/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Custom styles for this template -->
<link href="../themes/assets/css/carousel.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<div class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.html">Athlone IT's Take
							Away</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">About Us</a></li>
							<li class="active"><a href="contact.html">Contact</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Menus <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">All</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">Types</li>
									<li><a href="#">Chinese</a></li>
									<li><a href="#">Others</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Member <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="login.jsp">Login</a></li>
									<li><a href="register.jsp">Register</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>




	<div class="pageTitle">
		<div class="container">
			<h2>Login Page</h2>
		</div>
	</div>
	<br>
	<br>
	<br>
	<center>
		<div>
			<form action="../adminLogin" method="post">
				<table>
					<tr>
						<td colspan="2" style="text-align: center">Login</td>
					</tr>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="admin_name"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="admin_pwd"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input
							type="submit" value="Login"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	<br>
	<br>
	<br>
	<!-- FOOTER -->
	<footer>
		<div class="container">
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot;
				<a href="#">Terms</a>
			</p>
		</div>
	</footer>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="../themes/dist/js/bootstrap.min.js"></script>
	<script src="../themes/assets/js/holder.js"></script>
</body>
</html>

