<html>
<head>
<title>Alteração de Dados de Cursos</title>
</head>
<body>

<table border="0" width="750">
<tr>
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
</table>

<?php
include 'config.php';
include 'mysqlexecuta.php';
$con = conectar();
mysql_select_db('bdescola');
$codcurso = $_POST["codcurso"];
$nome = $_POST["nome"];
$coddisc1 = $_POST["coddisc1"];
$coddisc2 = $_POST["coddisc2"];
$coddisc3 = $_POST["coddisc3"];

$sql = "UPDATE cursos set Nome = '$nome', coddisc1 = '$coddisc1', coddisc2 = '$coddisc2', coddisc3 ='$coddisc3'
where codcurso = $codcurso";
$res = mysqlexecuta($con,$sql);
?>
<p align="center"><b><font color="#FF0000">Cadastro de Curso Alterado com Sucesso!!!</font></b></p>
<br><br><br>

<p> <a href='PesqCurs_Geral.php'><p align="center">Verificar Alteração</a></p>
</body>
</html>