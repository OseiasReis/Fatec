<html>
<head>
<title>PHP - Inclusão de registro na tabela Disciplinas</title>
</head>
<body>
<table border="0" width="1600" height="200">
<tr><td colspan=5 align="center"><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
</table>
<?php //resgatando as variaveis postadas no CadAlunos
$coddisc = $_POST["txtcoddisc"];
$nome = $_POST["txtnome"];

include 'config.php';
include 'mysqlexecuta.php';

$con = conectar();
mysql_select_db('bdescola');
$sql = "INSERT INTO disciplinas (CodDisciplina, NomeDisciplina)Values('$coddisc', '$nome')";

$res = mysqlexecuta($con,$sql);
echo "<p align='center'>Inclusão efetuada com sucesso!!!"."<BR>";
echo "<p align='center'><a href='menu.html'>Menu Principal...</a></p>";
?>
</body>
</html>