<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<title> 5 Caixas de Texto</title>
	</head>
	<body>
		<form method="get" action="Aula7_Exemplo04_1.php">
			<?php
			$cont= 1;
			while ($cont <= 5) {
				echo "<b><label for='cValor$cont'>Valor $cont: </label>
				<input type='number' name='tValor$cont' id='cValor$cont' max='100' 
				min='0' value='0'/> </b><br /><br />";
				$cont++;
			}
			
			?>
				<input type="submit" value="Enviar">
		</form>
	</body>
</html>