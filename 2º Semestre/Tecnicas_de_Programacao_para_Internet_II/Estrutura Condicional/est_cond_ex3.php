<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Estrutura Condicional Exemplo3</title>
</head>
	<body>

		<?php
			$ano = isset ($_GET["tAno"])?$_GET["tAno"]:1900;
			$idade = date("Y") - $ano;
				echo "Você nasceu em $ano e tem $idade anos.<br />";
				if($idade < 16) {
					$tipoVoto = "não vota";
				}
				elseif(($idade >= 16 && $idade < 18) || ($idade > 65)) {
						$tipoVoto = "voto opcional";
					}
					else {
						$tipoVoto = "voto obrigatório";
					}
				echo "Com essa idade, $tipoVoto.<br />";
		?>
		<a href="est_cond_ex3.html">Voltar
	</body>
</html>