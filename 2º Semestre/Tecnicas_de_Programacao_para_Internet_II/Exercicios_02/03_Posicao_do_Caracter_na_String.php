<?php

$texto = "PI - Programacao Para Internet";
$x = strpos($texto, "P");
while ($x !== false){
	echo $x . " ";
	$x = strpos($texto, "P", $x+1);
	}
	echo "<br>------------------------------------------------------------------<br />";

$y = strpos($texto, "r");
while ($y !== false){
	echo $y . " ";
	$y= strpos($texto, "r", $y+1);
	}
	echo "<br>------------------------------------------------------------------<br />";

$frase = "PI - Programacao para Internet - PI PHP";
$z = strpos($frase, "PI");
while ($z !== false){
	echo $z . " ";
	$z = strpos($frase, "PI", $z+1);
	}
	echo "<br>------------------------------------------------------------------<br />";
	
?>