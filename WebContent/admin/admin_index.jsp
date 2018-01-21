<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="takeaway_JSPwebsite.models.admin"%>
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



<!-- Custom styles for this template -->
<link href="../themes/assets/css/carousel.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<%
	try {
		admin Admin = (admin) session.getAttribute("Admin");
		Admin.getAdminName();

	} catch (Exception e) {
		response.sendRedirect("../index.jsp");
	}
%>
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


				</div>
			</div>




			<div class="pageTitle">
				<div class="container">
					<h2>Control Panel</h2>
				</div>
			</div>

			<div class="container">
				Add new course
				<div class="bodyInner">
					<form action="../addNewCourse" method="post">
						<table>
							<tr>
								<td>Course Name:<input type="text" name="courseName"></td>
								<td>Course Type:<input type="text" name="courseType"></td>
								<td>Course Description:<input type="text"
									name="courseDescription"></td>
								<td>Course Price:<input type="text" name="coursePrice"></td>
								<td><input type="submit" value="Submit"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<div class="container">
				<p style=" font-weight:bold; color:#F00; font-size:18px">Orders</p>
				<div class="bodyInner">
                <center>
					<table cellspace="5px" cellspadding="5px" style="border:2px #000000 thick; width:80%;">
						<tr>
							<td>Username</td>
							<td>Courses</td>
							<td>Price</td>
							<td>Address</td>
							<td>Phone</td>
							<td>Order Time</td>
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
								String getOrders = "select orders.*, user.address, user.phone from orders, user where orders.username=user.username order by order_time desc;";
								rs = stmt.executeQuery(getOrders);
								while (rs.next()) {
						%>
						<tr>
							<td><%=rs.getString("username")%></td>
							<td><%=rs.getString("courses")%></td>
							<td><%=rs.getString("price")%></td>
							<td><%=rs.getString("address")%></td>
							<td><%=rs.getString("phone")%></td>
							<td><%=rs.getDate("order_time").toGMTString()%></td>
						</tr>
						<%
							}
								// stmt.close();
								// conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						%>
					</table>
                    </center>
				</div>
			</div>



			<!-- FOOTER -->
			<footer>
				<div class="container">
					<p class="pull-right">
						<a href="#">Back to top</a>
					</p>
					<p>
						&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a>
						&middot; <a href="#">Terms</a>
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

