<?php
$i = 1;
while($i <= 5){
	$valor = $i;
	$url = "tValor". $i;
	$$valor = isset ($_GET[$url])?$_GET["$url"]:0;
	$i++;
}
$i = 1;
while($i <= 5){
	$valor = $i;
	echo "<b>Valor $i ==>> </b>".$$valor. "<br /><br />";
	$i++;
}
?>
<a href="Aula7_Exemplo04.php">Voltar</a>