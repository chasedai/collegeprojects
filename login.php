<?php
ob_start();
// Get data
$username = $_GET["username"];
$password = $_GET["password"];
// Database connection
$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("wordpress", $con);

$check_query = mysql_query("select password from web_user where username = '$username';");
$Row = mysql_fetch_row($check_query);
if($password===$Row[0]){
    //登录成功
	session_start();  
    $_SESSION['username'] = $username;
	header("Location: http://127.0.0.1:4001/wordpress/?page_id=153 ");
} else {   
	echo "login failed";
}  
ob_end_flush();
?>

