<html>
<head>
<title>PHP - Inclusão de registro na tabela Alunos</title>
</head>
<body>
<table border="0" width="750">
<tr><td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
</table>
<?php //resgatando as variaveis postadas no CadAlunos
$codmatr = $_POST["txtcodmatr"];
$nome = $_POST["txtnome"];
$codend = $_POST["txtcodend"];
$codcid = $_POST["txtcodcid"];
$codcurso = $_POST["txtcodcurso"];

include 'config.php';
include 'mysqlexecuta.php';

$con = conectar();
mysql_select_db('bdescola');
$sql = "INSERT INTO alunos (Matricula, Nome, Endereco, Cidade, CodCurso)Values('$codmatr', '$nome', 
'$codend', '$codcid', '$codcurso')";

$res = mysqlexecuta($con,$sql);
echo "<p align='center'>Inclusão efetuada com sucesso!!!"."<BR>";
echo "<p align='center'><a href='menu.html'>Menu Principal...</a></p>";
?>
</body>
</html>