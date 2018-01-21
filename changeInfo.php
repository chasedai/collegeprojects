<?php
ob_start();
// Get data
$username = $_POST["username"];
$password = $_POST["password"];
$address = $_POST["address"];
$phone = $_POST["phoneno"];
// Database connection
$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("wordpress", $con);

mysql_query("UPDATE web_user set password='$password', address='$address', phoneNo='$phone' where username='$username'");
echo $username;
echo $password;
echo $address;
echo $phone;
mysql_close($con);
header("Location: http://127.0.0.1:4001/wordpress/?page_id=153");
ob_end_flush();
?>