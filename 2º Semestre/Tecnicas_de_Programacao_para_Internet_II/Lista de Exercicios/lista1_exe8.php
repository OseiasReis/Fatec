<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 8</title>
</head>
	<body>

		<?php
			$MO = isset ($_GET["tMO"])?$_GET["tMO"]:0;
			$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
			$n2 = isset ($_GET["tn2"])?$_GET["tn2"]:0;
			$n3 = isset ($_GET["tn3"])?$_GET["tn3"]:0;
			
			switch ($MO) {
				case 1:
					$res = $n1 + $n2;
					echo "A soma de $n1 + $n2 é $res";
					break;
				case 2:
					$res = sqrt($n3);
					echo "A raiz quadrada de $n3 é $res<br />";
			}
		?>
		<a href="lista1_exe8.html"><br />Voltar
	</body>
</html>