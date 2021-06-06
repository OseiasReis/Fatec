<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 5</title>
</head>
<body>

<?php
		$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
		$n2 = isset ($_GET["tn2"])?$_GET["tn2"]:0;
		$n3 = isset ($_GET["tn3"])?$_GET["tn3"]:0;
		$n4 = isset ($_GET["tn4"])?$_GET["tn4"]:0;
		
			if($n1 >= $n2 && $n1 >= $n3 && $n2 >= $n3 && $n1 >= $n4 && $n2 >= $n4 && $n3 >= $n4) {
				echo "<b>Ordem Decrescente<br />"
					."$n4<br />"
					."$n3<br />"
					."$n2<br />"
					."$n1</b>";
				}
				else {
					if($n1 >= $n2 && $n1 >= $n3 && $n2 >= $n3 && $n1 >= $n4 && $n2 >= $n4 && $n3 <= $n4) {
						echo "<b>Ordem Decrescente<br />"
						."$n3<br />"
						."$n4<br />"
						."$n2<br />"
						."$n1</b>";
					}
				else {
					if($n1 >= $n2 && $n1 >= $n3 && $n2 >= $n3 && $n1 >= $n4 && $n2 <= $n4 && $n3 <= $n4) {
						echo "<b>Ordem Decrescente<br />"
						."$n3<br />"
						."$n2<br />"
						."$n4<br />"
						."$n1</b>";
						}
				else {
					if($n1 >= $n2 && $n1 >= $n3 && $n2 >= $n3 && $n1 <= $n4 && $n2 <= $n4 && $n3 <= $n4) {
						echo "<b>Ordem Decrescente<br />"
						."$n3<br />"
						."$n2<br />"
						."$n1<br />"
						."$n4</b>";
						}
						else {
							echo "<b>Os tres primeiro números não foram digitados em ordem crescente</b>";
						}
					}
				}
			}
?>
	<a href="lista1_exe5.html"> <hr /> Voltar
</body>
</html>