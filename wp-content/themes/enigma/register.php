<?php
ob_start();
// Get data
$username = $_GET["username"];
$password = $_GET["password"];
$address = $_GET["address"];
$phone = $_GET["phone"];
// Database connection
$conn = mysqli_connect("localhost","root","","wordpress");
if(!$conn) {
die('Problem in database connection: ' . mysql_error());
}else{
	echo "sssssssss";
}

// Data insertion into database
$query = "INSERT INTO web_user VALUES ('$username', '$password',
'$address', 0,'$phone' )";
$QueryResult = mysqli_query($conn, $query) or die(mysqli_error($conn));
if ($QueryResult===FALSE)
echo "<p>Unable to execute the query.</p>"
. "<p>Error code " . mysqli_errno($conn)
. ": " . mysqli_error($conn) . "</p>";
else
//echo "<p>Successfully executed the query!!!</p>";
// Redirection to the success page
header("Location: http://www.baidu.com/");
ob_end_flush();
?>