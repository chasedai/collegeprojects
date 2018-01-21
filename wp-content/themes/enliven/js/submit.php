<?php
// Get data
$username = $_GET["username"];
$password = $_GET["password"];
// Database connection
$conn = mysqli_connect("localhost","root","","wordpress");
if(!$conn) {
die('Problem in database connection: ' . mysql_error());
}
// Data insertion into database
$query = "INSERT INTO my_cust_details( customer_name, customer_email, customer_age ) VALUES ('$customer_name', '$customer_email',
'$customer_age' )";
$QueryResult = mysqli_query($conn, $query) or die(mysqli_error($conn));
if ($QueryResult===FALSE)
echo "<p>Unable to execute the query.</p>"
. "<p>Error code " . mysqli_errno($conn)
. ": " . mysqli_error($conn) . "</p>";
else
//echo "<p>Successfully executed the query!!!</p>";
// Redirection to the success page
header("Location: http://127.0.0.1:4001/wordpress/success-page/");
?>