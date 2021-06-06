<?php
	$num = isset($_GET["tNum"])?$_GET["tNum"]:1;
		echo "<legend> Tabuada do $num </legend>";
	for($cont = 1; $cont <= 10; $cont++) {
		$res = $num * $cont;
		echo "$num x $cont = $res <br />";
	}
?>
<a href="Aula7_Exemplo08.php">Voltar</a>