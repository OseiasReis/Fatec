<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Estrutura Condicional Exemplo1</title>
</head>
	<body>

		<?php
			$ano = isset ($_GET["tAno"])?$_GET["tAno"]:1900;
			$idade = date("Y") - $ano;
				echo "Você nasceu em $ano e tem $idade anos.<br />";
				if($idade >= 18) {
					$vota = "já pode votar";
					$dirige = "já pode dirigir";
				}
				else {
					$vota = "não pode votar";
					$dirige = "não pode dirigir";
				}
				echo "Com essa idade você $vota eh também $dirige .";
		?>
		<a href="est_cond_ex1.html">Voltar
	</body>
</html>