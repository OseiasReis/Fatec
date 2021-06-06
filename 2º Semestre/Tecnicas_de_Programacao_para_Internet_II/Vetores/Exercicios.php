<?php

echo "<b>LISTA DE EXERCICIOS 01" ."<br />"
."NOME: Oséias P. Reis" ."</b><br />";

echo "<hr />";
echo "<b>Exercicio 01:" ."</b><br />";

function mediaDeArray($notas, $pesos){
	$resultado = 0;
	
	for($x=0; $x<sizeof($notas); $x++){
		$resultado += ($notas[$x] / 10) * $pesos[$x];
	}
	
	return $resultado;
}

echo mediaDeArray(array(7, 8, 10), array(2, 3, 5));

echo "<hr />";




echo "<b>Exercicio 02:" ."</b><br />";

function inverteArray($array) {
	$novoArray = array();
	
	for($x=sizeof($array) - 1; $x>=0; $x--){
		$novoArray[sizeof($array) - 1 - $x] = $array[$x];
	}
	
	return $novoArray;
	
}
print_r(inverteArray(array("a", "b", "c", "d")));

echo "<hr />";




echo "<b>Exercicio 03:" ."</b><br />";

function tamanhoDeArray($array){
	$x = 0;
	foreach($array as $posicao){
		$x++;
	}
	return $x;
}
echo tamanhoDeArray(array(1, 2, 3));

echo "<hr />";




echo "<b>Exercicio 04:" ."</b><br />";

function meu_array_push($array, $elemento){
	$array[sizeof($array)] = $elemento;
	return $array;
}
$x = array(1, 2, 3);
$x = meu_array_push($x, 4);
print_r($x);

echo "<hr />";




echo "<b>Exercicio 05:" ."</b><br />";

function meu_array_pop($array){
	$elemento = $array[sizeof($array) - 1];
	unset($array[sizeof($array) - 1]);
	return $elemento;
}
$x = array(1, 2, 3);
echo meu_array_pop($x) ."<br />";
print_r($x);

echo "<hr />";




echo "<b>Exercicio 06:" ."</b><br />";

function meu_array_shift($array){
	$elemento = $array[0];
	unset($array[0]);
	return $elemento;
}
$x = array(1, 2, 3);
echo meu_array_shift($x) ."<br />";
print_r($x);

echo "<hr />";




echo "<b>Exercicio 07:" ."</b><br />";

function meu_array_unshift($array, $elemento){
	
	for($x=sizeof($array); $x>0; $x--){
	$array[$x] = $array[$x-1];
	}
	
	$array[0] = $elemento;
	return $array;
}
$x = array(1, 2, 3);
$x = meu_array_unshift($x, 4);
print_r($x);

echo "<hr />";




echo "<b>Exercicio 08:" ."</b><br />";

function minha_array_key_exists($chaveBusca, $array){
	$chaves = array_keys($array);
	
	foreach($chaves as $chave){
		if($chave == $chaveBusca) {
			return TRUE;
		}
	}
	return FALSE;
}
$x = array("Componente" => "DSI", "Professor" => "Roberto");
echo minha_array_key_exists("Componente", $x);
echo minha_array_key_exists("DSI", $x);
echo "<hr />";

?>