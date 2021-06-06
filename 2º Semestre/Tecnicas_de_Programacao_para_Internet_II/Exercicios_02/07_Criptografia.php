<?php

//crypt - senha hash
$senha = "123abc";
$senhaHash = crypt($senha, 1);
$senhaVolta = "123abc";
$novoHash = crypt($senhaVolta, 1);
	echo $senhaHash . " = " . $novoHash;
	echo "<br /><br />";
	
//md5
$senha = "123abc";
$senhaHash = md5($senha);
$senhaVolta = "123abc";
$novoHash = md5($senhaVolta);
	echo $senhaHash . " = " . $novoHash;
	echo "<br /><br />";
	
//sha1
$senha = "123abc";
$senhaHash = sha1 ($senha, 1);
$senhaVolta = "123abc";
$novoHash = sha1($senhaVolta, 1);
	echo $senhaHash . " = " . $novoHash;
	echo "<br /><br />";

?>