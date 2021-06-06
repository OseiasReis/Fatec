<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Exercicio 7</title>
</head>
<body>

<?php
		$I = isset ($_GET["tI"])?$_GET["tI"]:0;
		$A = isset ($_GET["tA"])?$_GET["tA"]:0;
		$B = isset ($_GET["tB"])?$_GET["tB"]:0;
		$C = isset ($_GET["tC"])?$_GET["tC"]:0;
		
			if($I == 1) {
				if ($A >= $B && $A >= $C && $B >= $C){
				echo "<b>Ordem Crescente<br />"
					."$C<br />"
					."$B<br />"
					."$A<br /></b>";
				}
					else {
						if ($A >= $B && $A >= $C && $B <= $C) {
						echo "<b>Ordem Crescente<br />"
						."$B<br />"
						."$C<br />"
						."$A<br /></b>";
						}
						else {
							if ($B >= $A && $B >= $C && $A >= $C) {
							echo "<b>Ordem Crescente<br />"
							."$C<br />"
							."$A<br />"
							."$B<br /></b>";
							}
							else {
								if ($B >= $A && $B >= $C && $A <= $C) {
								echo "<b>Ordem Crescente<br />"
								."$A<br />"
								."$C<br />"
								."$B<br /></b>";
								}
								else {
									if ($C >= $A && $C >= $B && $B >= $A) {
									echo "<b>Ordem Crescente<br />"
									."$A<br />"
									."$B<br />"
									."$C<br /></b>";
									}
									else {
										if ($C >= $A && $C >= $B && $B <= $A) {
										echo "<b>Ordem Crescente<br />"
										."$B<br />"
										."$A<br />"
										."$C<br /></b>";
										}
									}
								}
							}
						}
					}
			}
					if ($I == 2){
					if ($A >= $B && $A >= $C && $B >= $C){
						echo "<b>Ordem Decrescente<br />"
						."$A<br />"
						."$B<br />"
						."$C<br /></b>";
						}
					else {
						if ($A >= $B && $A >= $C && $B <= $C) {
						echo "<b>Ordem Decrescente<br />"
						."$A<br />"
						."$C<br />"
						."$B<br /></b>";
						}
						else {
							if ($B >= $A && $B >= $C && $A >= $C) {
							echo "<b>Ordem Decrescente<br />"
							."$B<br />"
							."$A<br />"
							."$C<br /></b>";
							}
							else {
								if ($B >= $A && $B >= $C && $A <= $C) {
								echo "<b>Ordem Decrescente<br />"
								."$B<br />"
								."$C<br />"
								."$A<br /></b>";
								}
								else {
									if ($C >= $A && $C >= $B && $B >= $A) {
									echo "<b>Ordem Decrescente<br />"
									."$C<br />"
									."$B<br />"
									."$A<br /></b>";
									}
									else {
										if ($C >= $A && $C >= $B && $B <= $A) {
										echo "<b>Ordem Decrescente<br />"
										."$C<br />"
										."$A<br />"
										."$B<br /></b>";
											}
										}
									}
								}
							}
						}
					}
				if($I == 3) {
				if ($A >= $B && $A >= $C && $B >= $C){
				echo "<b>O Maior Está Entre os Dois Números<br />"
					."$B<br />"
					."$A<br />"
					."$C<br /></b>";
					}
					else {
						if ($A >= $B && $A >= $C && $B <= $C) {
						echo "<b>O Maior Está Entre os Dois Números<br />"
						."$C<br />"
						."$A<br />"
						."$B<br /></b>";
						}
						else {
							if ($B >= $A && $B >= $C && $A >= $C) {
							echo "<b>O Maior Está Entre os Dois Números<br />"
							."$A<br />"
							."$B<br />"
							."$C<br /></b>";
							}
							else {
								if ($B >= $A && $B >= $C && $A <= $C) {
								echo "<b>O Maior Está Entre os Dois Números<br />"
								."$C<br />"
								."$B<br />"
								."$A<br /></b>";
								}
								else {
									if ($C >= $A && $C >= $B && $B >= $A) {
									echo "<b>O Maior Está Entre os Dois Números<br />"
									."$B<br />"
									."$C<br />"
									."$A<br /></b>";
									}
									else {
										if ($C >= $A && $C >= $B && $B <= $A) {
										echo "<b>O Maior Está Entre os Dois Números<br />"
										."$A<br />"
										."$C<br />"
										."$B<br /></b>";
										}
									}
								}
							}
						}
					}
				}
				else 
					echo "I = Número Invalido, Tente Outro";

?>
	<a href="lista1_exe7.html"> <hr /> Voltar
</body>
</html>