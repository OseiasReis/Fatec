<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 10</title>
</head>
	<body>

		<?php
			$Dia1 = isset ($_GET["td1"])?$_GET["td1"]:0;
			$Dia2 = isset ($_GET["td2"])?$_GET["td2"]:0;
			$Mes1 = isset ($_GET["tm1"])?$_GET["tm1"]:0;
			$Mes2 = isset ($_GET["tm2"])?$_GET["tm2"]:0;
			$Ano1 = isset ($_GET["ta1"])?$_GET["ta1"]:0;
			$Ano2 = isset ($_GET["ta2"])?$_GET["ta2"]:0;
			
			$Data1 = ($Ano1 * 100 + $Mes1) * 100 + $Dia1;
			$Data2 = ($Ano2 * 100 + $Mes2) * 100 + $Dia2;
			
			if ($Data1 > $Data2)
				echo("$Dia1/$Mes1/$Ano1 <br /> $Dia2/$Mes2/$Ano2");
			else
				echo("$Dia2/$Mes2/$Ano2 <br /> $Dia1/$Mes1/$Ano1");
		?>
		<a href="lista1_exe10.html"><br />Voltar
	</body>
</html>