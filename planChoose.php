<?php
// Get data
session_start();
$plan = $_POST["plan"];
$square = $_POST["square"];
if($plan=="entry level"&&$square==50){
	$_SESSION["price"]=50;
}if($plan=="entry level"&&$square==100){
	$_SESSION["price"]=100;
}else if($plan=="entry level"&&$square==150){
	$_SESSION["price"]=150;
}else if($plan=="All around"&&$square==50){
	$_SESSION["price"]=100;
}else if($plan=="All around"&&$square==100){
	$_SESSION["price"]=150;
}else if($plan=="All around"&&$square==150){
	$_SESSION["price"]=200;
}else if($plan=="Advanced"&&$square==50){
	$_SESSION["price"]=150;
}else if($plan=="Advanced"&&$square==100){
	$_SESSION["price"]=200;
}else if($plan=="Advanced"&&$square==150){
	$_SESSION["price"]=250;
}
header("Location: http://127.0.0.1:4001/wordpress/?page_id=179");
?>

