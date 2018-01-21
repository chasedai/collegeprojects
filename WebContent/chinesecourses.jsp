<%@page import="takeaway_JSPwebsite.models.user"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
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
<link rel="shortcut icon" href="themes/assets/ico/favicon.ico">
<title>Athlone IT's Take Away</title>

<!-- Bootstrap core CSS -->
<link href="themes/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="themes/assets/css/carousel.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<%
	user User = (user)session.getAttribute("User");
%>
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.html">Athlone IT's Take Away</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li ><a href="index.html">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                <li><a href="contact.html">Contact</a></li>
				<li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menus <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">All</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Types</li>
                    <li><a href="#">Chinese</a></li>
                    <li><a href="#">Others</a></li>
                  </ul>
                </li>
                <%
                	try{
                %>
				<li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%="Hi, "+User.getUsername() %> <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li><a href="log-out.jsp">Log out</a></li>
                  </ul>
                </li>
                <%
                	}catch(Exception e){
                %>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Member <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                  </ul>
                </li>
                <%
                	}
                %>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>






	<div class="pageTitle">
		<div class="container">
			<h2>Menu Page</h2>
		</div>
	</div>

	<div class="container">
		Menu
		<div class="bodyInner">
			<table  cellspace="5px" cellspadding="5px" style="border:2px #000000 thick; width:80%;">
				<tr>
					<td>Course</td>
					<td>Description</td>
					<td>Price</td>
					<td>Action</td>
				</tr>
				<%
					Connection conn = null;
					Statement stmt;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("success");
					} catch (ClassNotFoundException e1) {
						System.out.println("Driver not found");
						e1.printStackTrace();
					}

					String url = "jdbc:mysql://localhost:3306/takeawayrest";
					ResultSet rs;
					try {
						conn = (Connection) DriverManager.getConnection(url, "root",
								"admin");
						stmt = (Statement) conn.createStatement();
						String getOrders = "select * from courses;";
						rs = stmt.executeQuery(getOrders);
						while (rs.next()) {
							String course_name =rs.getString("course_name");
							String course_description =rs.getString("course_description");
							String price =rs.getString("price");
							String img_path = rs.getString("img_path");
							System.out.println(img_path);
							//int i = rs.getRow();
							//session.setAttribute(i+"", i);
							//session.setAttribute(i+"course_name", course_name);
							//session.setAttribute("course_description", course_description);
							//session.setAttribute("price", price);
				%>
				<form action="makeOrder" method="get">
				<tr>
					<td><img alt="<%=course_name%>" src="<%=img_path%>" height='80px' width='80px'></td>
					<td><input type="text" name="courseName" value="<%=course_name%>" style="display: none"><%=course_description%></td>
					<td><input type="text" name="price" value="<%=price%>" readonly="readonly"></td>
					<td><input type="submit" value="order"></td>
				</tr>
				</form>
				<%
					}
						// stmt.close();
						// conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				%>
			</table>
		</div>
	</div>

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
	<script src="themes/dist/js/bootstrap.min.js"></script>
	<script src="themes/assets/js/holder.js"></script>
</body>
</html>

