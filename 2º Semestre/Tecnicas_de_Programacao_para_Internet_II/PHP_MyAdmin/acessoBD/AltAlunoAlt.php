<html>
<head>
<title>Alteração de Dados de Alunos</title>
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
$matricula = $_POST["matricula"];
$nome = $_POST["nome"];
$endereco = $_POST["endereco"];
$cidade = $_POST["cidade"];
$cod_curso = $_POST["codcurso"];

$sql = "UPDATE alunos set Nome = '$nome', endereco = '$endereco', cidade = '$cidade', codcurso ='$cod_curso'
where matricula = $matricula";
$res = mysqlexecuta($con,$sql);
?>
<p align="center"><b><font color="#FF0000">Cadastro de Aluno Alterado com Sucesso!!!</font></b></p>
<br><br><br>

<p> <a href='PesqAlun_Geral.php'><p align="center">Verificar Alteração</a></p>
</body>
</html>