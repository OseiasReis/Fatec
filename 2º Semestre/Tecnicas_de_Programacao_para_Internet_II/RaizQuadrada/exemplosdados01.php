<DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/ >
	<title> Integrando Raiz </title>
</head>
<body>
	<?php
	$valor = $_GET["tValor"];
	$raizq = sqrt($valor);
		echo"A raiz $valor é igual a " . number_format($raizq,2)
		."<hr />";
	?>
	<a href="raiz_quadrada.html">Voltar</a>
</body>
</html>