<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 12</title>
</head>
	<body>

		<?php
			$CO = isset ($_GET["tCO"])?$_GET["tCO"]:0;
			$SA = isset ($_GET["tSA"])?$_GET["tSA"]:0;
			switch ($CO) {
				case 1:
					$por = (50 / 100) * $SA;
					$res = $SA + $por;
					
					echo "<b>Escriturário<br />"
					."Valor de Aumento: 50%<br />"
					."Salario Novo: $res </b>";
					break;
				case 2:
					$por = (35 / 100) * $SA;
					$res = $SA + $por;
					
					echo "<b>Secretario<br />"
					."Valor de Aumento: 35%<br />"
					."Salario Novo: $res </b>";
					break;
				case 3:
					$por = (20 / 100) * $SA;
					$res = $SA + $por;
					
					echo "<b>Caixa<br />"
					."Valor de Aumento: 20%<br />"
					."Salario Novo: $res </b>";
					break;
				case 4:
					$por = (10 / 100) * $SA;
					$res = $SA + $por;
					
					echo "<b>Gerente<br />"
					."Valor de Aumento: 10%<br />"
					."Salario Novo: $res </b>";
					break;
				case 5:
					echo "<b>Diretor<br />"
					."Salario Novo: Não tem aumento </b></b>";
					break;
			}
		?>
		<a href="lista1_exe12.html"><br />Voltar
	</body>
</html>