<?php
ob_start();
// Get data
session_start();
$username = $_SESSION["username"];
$price = $_SESSION["price"];
$staffname = $_GET["staffname"];
$cleandate = $_GET["cleandate"];
// Database connection
$conn = mysqli_connect("localhost","root","","wordpress");
if(!$conn) {
die('Problem in database connection: ' . mysql_error());
}else{
	echo "sssssssss";
}

$query = "INSERT INTO web_order VALUES ('$username', '$staffname','$price',
sysdate(), '$cleandate' )";
$query2 = "update web_user set balance = balance - '$price' where username='$username'";
if(mysqli_query($conn, $query)){  
    //登录成功
	if(mysqli_query($conn, $query2)){
		header("Location: http://127.0.0.1:4001/wordpress/?page_id=153 ");
	}
} else {   
	echo "chenggong1";
}  
ob_end_flush();
?>

