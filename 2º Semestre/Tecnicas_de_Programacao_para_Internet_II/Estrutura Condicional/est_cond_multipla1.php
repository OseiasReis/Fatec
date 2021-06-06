<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Estrutura Condicional Exemplo3</title>
</head>
	<body>

		<?php
			$num = isset ($_GET["tNum"])?$_GET["tNum"]:0;
			$op = isset ($_GET["tOp"])?$_GET["tOp"]:1;
			switch ($op) {
				case 1:
					$res = $num * 2;
					break;
				case 2:
					$res = pow($num, 3);
					break;
				case 3:
					$res = sqrt($num);
			}
				echo "O resultado oeração é $res<br />";
		?>
		<a href="est_cond_multipla1.html">Voltar
	</body>
</html>