<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 3</title>
</head>
<body>

<?php
		$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
		$n2 = isset ($_GET["tn2"])?$_GET["tn2"]:0;
		
			if($n1 > $n2) {
				echo "<b>$n1 é o maior número</b>";
			}
				else {
					echo "<b>$n2 é o maior número</b>";
					}
?>
	<a href="lista1_exe3.html"> <hr /> Voltar
</body>
</html>