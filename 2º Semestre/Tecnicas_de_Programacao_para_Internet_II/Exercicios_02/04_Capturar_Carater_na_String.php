<?php

echo "<b>Capturar Caracter</b><br />";
$str = "contato@dominio.com.br";
$x = strchr($str, "@");
echo $x;

?>

<br /><br />

<?php

echo "<b>Capturar Substring</b><br />";
$str = "contato@dominio.com.br";
$inicio = strpos($str, "@");
$fim = strpos($str, ".", $inicio);
$x = substr($str, $inicio+1, $fim-$inicio-1);
echo $x;

?>

<br /><br />

<?php

echo "<b>Substituir Substring</b><br />";
$str = "Aprendendo PHP em PI. PHP eh bem legal!!!";

$str = str_replace("PHP", "Java", $str);
echo $str;

?>