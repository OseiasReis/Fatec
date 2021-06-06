<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 1</title>
</head>
<body>

<?php
		$TDL = isset ($_GET["tTDL"])?$_GET["tTDL"]:0;
		$AS = isset ($_GET["tAS"])?$_GET["tAS"]:0;
		$EF = isset ($_GET["tEF"])?$_GET["tEF"]:0;
			echo 
			"<b>Trabalho&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			&nbsp&nbsp&nbsp&nbspPeso<br />"
			." ________________________ <br />"
			."|Trabalho de Lab. ------- &nbsp&nbsp2 |<br />"
			."|Avaliação Semes. ------- &nbsp&nbsp3 |<br />"
			."|Exame Final      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp------- &nbsp&nbsp5 |</b><br />"
			." ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯ <br />";
			
		$MP = (($TDL*2) + ($AS*3) + ($EF*5)) / (2+3+5);
		
			if($MP >= 8.0 && $MP <= 10.0) {
				echo "Nota $MP , Conceito A";
			}
			else {
				if($MP >= 7.0 && $MP < 8.0) {
					echo "Nota $MP , Conceito B";
				}
				else {
					if($MP >= 6.0 && $MP < 7.0) {
						echo "Nota $MP , Conceito C";
					}
					else {
						if($MP >= 5.0 && $MP < 6.0) {
							echo "Nota $MP , Conceito D";
						}
						else {
							echo "Nota $MP , Conceito E";
						}
					}
				}
			}
?>
	<a href="lista1_exe1.html"> <hr /> Voltar
</body>
</html>