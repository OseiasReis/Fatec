<?php
	$valor = isset($_GET["tValor"])?$_GET["tValor"]:1;
	echo "<h1> Calculando o fatorial de $valor </h1>";
	$cont = $valor;
	$fat = 1;
	do {
		$fat = $fat*$cont;
		$cont--;
	} while ($cont >= 1);
	echo "<h2>$valor! = $fat</h2>";
?>
<a href="Matematica.php">Voltar</a>