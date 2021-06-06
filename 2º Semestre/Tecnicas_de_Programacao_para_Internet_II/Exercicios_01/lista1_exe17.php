<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 11</title>
<style>
h1 {
	color: #FF0000;
	font-size: 30px;
}
</style>
</head>
<body>
	<form method="get" action="ex11.php">
		<fieldset id="linha1" style="width:425px;height:125px;">
			<legend><h1>Número Primo ou Não Primo</h1></legend><br />
				<?php
				
				echo "<fieldset> <label for='cn1'><b>Numero Inteiro Maior Que 1: </b></label></b>
				<input type='number' name='tn1' id='cn1' placeholder='Número'/></fieldset> <br /></b>";
				
				?>

				<input type="submit" name="tEnviar" value="Enviar" /> <br /><br />
		</fieldset>
	</form>
</body>
</html>