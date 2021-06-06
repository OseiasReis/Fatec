<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Estrutura Condicional Multipla Escolha</title>
</head>
	<body>

		<?php
			$dia = isset ($_GET["tDia"])?$_GET["tDia"]:0;
			switch ($dia) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					echo "Vai para a escola.";
					break;
				case 7;
				case 8;
					echo "Fica em casa.<br />";
			}
		?>
		<a href="est_cond_multipla2.html">Voltar
	</body>
</html>