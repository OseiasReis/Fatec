<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 11</title>
</head>
	<body>

		<?php
			$HI = isset ($_GET["tHI"])?$_GET["tHI"]:0;
			$MI = isset ($_GET["tMI"])?$_GET["tMI"]:0;
			$HT = isset ($_GET["tHT"])?$_GET["tHT"]:0;
			$MT = isset ($_GET["tMT"])?$_GET["tMT"]:0;
			
			
			if ($HI > $HT){
				$TR = 1440 - $HI * 60 + $MI;
				$TR1 = $HT * 60 + $MT;
				
				echo "Tempo de Jogo: " . intval ($TR / 60) . ":" . intval ($TR1 % 60);
			}
			else{
				$TR = ($HT * 60 + $MT) - ($HI * 60 + $MI);
				$TR1 = $MT - $MI;

				echo "Tempo de Jogo: " . intval ($TR / 60) . ":" . intval ($TR1 % 60);
			}
		?>
		<a href="lista1_exe11.html"><br />Voltar
	</body>
</html>