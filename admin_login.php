<?php
ob_start();
// Get data
$admin = $_GET["admin"];
$adminpwd = $_GET["adminpwd"];
// Database connection

if($admin=="admin"&&$adminpwd=="admin"){  
    //登录成功
	session_start();  
    $_SESSION['admin'] = $admin;
	header("Location: http://127.0.0.1:4001/wordpress/?page_id=216 ");
} else {   
	echo "Validation failed";
}  
ob_end_flush();
?>

