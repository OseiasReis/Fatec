<DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/ >
	<title> Integrando Personalização</title>
	<?php
	$texto = isset ($_GET["tTexto"])?$_GET["tTexto"]:"Texto Genérico";
	$tam = isset ($_GET["tTam"])?$_GET["tTam"]:"12pt";
	$cor= isset ($_GET["tCor"])?$_GET["tCor"]:"#000000";
	?>
	<style>
		span.texto{
			font-size: <?php echo $tam; ?>
			color: <?php echo $cor; ?>
		}
	</style>
</head>
<body>
	<?php
	
	echo "<span class='texto'>$texto</span>";
	
	?>
	<a href="personalizacao.html"><br />Voltar</a>
</body>
</html>