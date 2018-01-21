<?php
ob_start();
// Get data
$staffname = $_POST["staffname"];
$password = $_POST["s_password"];
// Database connection
$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("wordpress", $con);

mysql_query("UPDATE web_staff set password='$password' where staffname='$staffname'");
mysql_close($con);
header("Location: http://127.0.0.1:4001/wordpress/?page_id=216");
ob_end_flush();
?>