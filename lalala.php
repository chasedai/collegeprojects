<?php  
	//session_start();  
  //检测是否登录，若没登录则转向登录界面  
	$conn = mysqli_connect("localhost","root","","wordpress");
	if(!$conn) {
	die('Problem in database connection: ' . mysql_error());
	}
	
	$QueryResult = mysql_query("select SUM(price), staffname from web_order group by staffname;");

require_once ('jpgraph/jpgraph.php');
require_once ('jpgraph/jpgraph_pie.php');
// Some data
$data = array(500,370);

// Create the Pie Graph. 
$graph = new PieGraph(350,250);

$theme_class="DefaultTheme";
//$graph->SetTheme(new $theme_class());

// Set A title for the plot
$graph->title->Set("A Simple Pie Plot");
$graph->SetBox(true);

// Create
$p1 = new PiePlot($data);
$graph->Add($p1);

$p1->ShowBorder();
$p1->SetColor('black');
$p1->SetSliceColors(array('#1E90FF','#2E8B57'));
$graph->Stroke();

?>