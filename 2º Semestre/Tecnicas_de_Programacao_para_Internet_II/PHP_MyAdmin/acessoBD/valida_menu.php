<?php
include 'config.php';
include 'mysqlexecuta.php';

$con = conectar();
mysql_select_db('bdescola');
$login = $_POST["txtlogin"];
$senha = $_POST["txtsenha"];
$sql="SELECT * FROM usuario where login like '$login' and senha like '$senha'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res)); //quantidades de linhas encontradas na consulta
if ($quant==0)
{
	echo "<p>Dados Incorretos !!!</p>";
	echo "<p align=left> <a href='index.html'>Voltar...</a></p>";
}

else
	
{
	header("location:menu.html");
}
?>