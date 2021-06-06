<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Operadores</title>
</head>
<body>
<?php
$valor1 = $_GET["a"];
$valor2 = $_GET["b"];
$rest = $valor1 + $valor2;

echo "<b>O valor A</b>: ".$valor1 ."<br /><b>O valor B</b>: ".$valor2 ."<br />";
echo "<b>Soma dos Dois Valores:</b>".$rest ."<br />";
?>
</body>
</html>