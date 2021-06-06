<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 6</title>
</head>
<body>

<?php
		$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
		
			if($n1 % 2 == 0) {
				echo "<b>$n1 é Par</b><br />";
				}
				else {
						echo "<b>$n1 é Impar</b><br />";
					}
?>
	<a href="lista1_exe6.html"> <hr /> Voltar
</body>
</html>