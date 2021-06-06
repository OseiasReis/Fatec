<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 11</title>
</head>
<body>

<?php
		$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
		
			if ($n1 == 0 || $n1 == 1){
				echo "Digite um Número Maior que 1";
			}
			
			$i = 0;
			
			for($i=2; $i * $i <= $n1; $i++){
				if ($n1 % $i == 0)
				echo "$n1 é um Numero <b>NÃO</b> Primo.";
				break;
			else
				echo "$n1 é um Numero Primo.";
			}
?>
	<a href="Exercicio11.php"> <hr /> Voltar</a>
</body>
</html>