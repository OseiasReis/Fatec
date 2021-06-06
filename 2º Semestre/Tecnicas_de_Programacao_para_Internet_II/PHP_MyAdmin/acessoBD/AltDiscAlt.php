<html>
<head>
<title>Alteração de Dados da Disciplina</title>
</head>
<body>

<table border="0" width="1600" height="200">
<tr>
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
</table>

<?php
include 'config.php';
include 'mysqlexecuta.php';
$con = conectar();
mysql_select_db('bdescola');
$coddisciplina = $_POST["coddisciplina"];
$nomedisciplina = $_POST["nomedisciplina"];

$sql = "UPDATE disciplinas set nomedisciplina = '$nomedisciplina' where coddisciplina = $coddisciplina";
$res = mysqlexecuta($con,$sql);
?>
<p align="center"><b><font color="#FF0000">Cadastro de Disciplina Alterado com Sucesso!!!</font></b></p>
<br><br><br>

<p> <a href='PesqDisc_Geral.php'><p align="center">Verificar Alteração</a></p>
</body>
</html>