<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 10</title>
</head>
<body>

<?php
		$IJ = isset ($_GET["tIJ"])?$_GET["tIJ"]:0;
		$PJ = isset ($_GET["tPJ"])?$_GET["tPJ"]:0;
		$AJ = isset ($_GET["tAJ"])?$_GET["tAJ"]:0;
		
		$JOGA = 55;
		$soma = 0;
		$QJI = 0;

		
		while ($IJ < 18)
		{
			$QJI++;
		}
		echo "$QJI de jogadores com a idade inferior a 18 anos.<br />";
		
?>

<?php
		$IJ = isset ($_GET["tIJ"])?$_GET["tIJ"]:0;
?>
	<a href="Exercicio10.php"> <hr /> Voltar</a>
</body>
</html>