<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<title>Tabuada</title>
	</head>
	<body>
		<form method="get" action="Aula7_Exemplo08_1.php">
			<select name="tNum">
			<?php
				for($cont = 1; $cont <= 10; $cont++) {
					echo "<option>$cont</option>";
				}
			?>
			</select>
			<input type="submit" value="Tabuada" />
		</form>
	</body>
</html>