<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 4</title>
</head>
<body>

<?php
		$n1 = isset ($_GET["tn1"])?$_GET["tn1"]:0;
		$n2 = isset ($_GET["tn2"])?$_GET["tn2"]:0;
		$n3 = isset ($_GET["tn3"])?$_GET["tn3"]:0;
		
			if($n1 >= $n2 && $n1 >= $n3 && $n2 >= $n3) {
				echo "<b>Ordem Crecente<br />"
				."$n1<br />"
				."$n2<br />"
				."$n3</b>";
			}
				else {
					if($n1 >= $n2 && $n1 >= $n3 && $n2 <= $n3) {
						echo "<b>Ordem Crecente<br />"
						."$n1<br />"
						."$n3<br />"
						."$n2</b>";
						}
				else {
					if($n2 >= $n1 && $n2 >= $n3 && $n1 <= $n3) {
						echo "<b>Ordem Crecente<br />"
						."$n2<br />"
						."$n3<br />"
						."$n1</b>";
						}
				else {
					if($n2 >= $n1 && $n2 >= $n3 && $n1 >= $n3) {
						echo "<b>Ordem Crecente<br />"
						."$n2<br />"
						."$n1<br />"
						."$n3</b>";
						}
				else {
					if($n3 >= $n1 && $n3 >= $n2 && $n2 <= $n1) {
						echo "<b>Ordem Crecente<br />"
						."$n3<br />"
						."$n1<br />"
						."$n2</b>";
						}
				else {
					if($n3 >= $n1 && $n3 >= $n2 && $n2 >= $n1) {
						echo "<b>Ordem Crecente<br />"
						."$n3<br />"
						."$n2<br />"
						."$n1</b>";
						}
					}
				}
			}
		}
	}
					
?>
	<a href="lista1_exe4.html"> <hr /> Voltar
</body>
</html>