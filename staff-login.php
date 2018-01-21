<?php
ob_start();
// Get data
$staffname = $_GET["staffname"];
$password = $_GET["password"];
// Database connection
$con = mysql_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

mysql_select_db("wordpress", $con);

$check_query = mysql_query("select password from web_staff where staffname = '$staffname';");
$Row = mysql_fetch_row(mysql_query("select password from web_staff where staffname = '$staffname';"));
if($password===$Row[0]){
	session_start();  
    $_SESSION['staffname'] = $staffname;
	header("Location: http://127.0.0.1:4001/wordpress/?page_id=171 ");
}
 else {   
	echo "login failed";
}  
ob_end_flush();
?>

