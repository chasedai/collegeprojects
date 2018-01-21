<?php
ob_start();
// Get data
$username = $_GET["username"];
$password = $_GET["password"];
// Database connection
$conn = mysqli_connect("localhost","root","","wordpress");
if(!$conn) {
die('Problem in database connection: ' . mysql_error());
}else{
	echo "sssssssss";
}

$check_query = "select * from web_user where username = '$username' and password = '$password';";
if(mysqli_query($conn, $check_query)){  
    //登录成功
	//session_start();  
    $_SESSION['username'] = $username;
	header("Location: http://127.0.0.1:4001/wordpress/?page_id=143 ");
} else {   
	echo "chenggong1";
}  
ob_end_flush();
?>

