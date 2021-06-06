<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 2</title>
</head>
<body>

<?php
		$TDL = isset ($_GET["tTDL"])?$_GET["tTDL"]:0;
		$AS = isset ($_GET["tAS"])?$_GET["tAS"]:0;
		$EF = isset ($_GET["tEF"])?$_GET["tEF"]:0;
	
		$MP = ($TDL + $AS + $EF) / 3;
		
			if($MP >= 7 && $MP <= 10) {
				echo "<b>Nota $MP = Aprovado</b>";
			}
			else {
				if($MP >= 3 && $MP < 7) {
					$exa = ($MP + 6) / 2;
					echo "<b>Nota $MP = Exame</b><br />"
					."Você tera que tirar uma nota $exa no exame, para ser aprovado.";
				}
					else {
						echo "<b>Nota $MP = Reprovado</b>";
						}
				}
?>
	<a href="lista1_exe2.html"> <hr /> Voltar
</body>
</html>