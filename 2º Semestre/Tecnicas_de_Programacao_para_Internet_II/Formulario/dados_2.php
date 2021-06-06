<DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/ >
	<title> Integrando Formulario 2</title>
</head>
<body>
	<?php
	$nome = isset ($_GET["tNome"])?$_GET["tNome"]:"[não informado]";
	$ano = isset ($_GET["tAno"])?$_GET["tAno"]:"[não informado]";
	$sexo = isset ($_GET["tSexo"])?$_GET["tSexo"]:"[não informado]";
	$idade = date ("Y") - $ano;
	
	echo "O seu nome é $nome, nasceu em $ano, é $sexo e tem $idade anos";
	
	?>
	<a href="formulario_2.html"><br />Voltar</a>
</body>
</html>