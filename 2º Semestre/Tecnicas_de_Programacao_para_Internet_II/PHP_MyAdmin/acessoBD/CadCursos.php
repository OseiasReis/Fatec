<html>
<head>
<title>PHP - Inclusão de registro na tabela Cursos</title>
</head>
<body>
<table border="0" width="750" align=center>
<tr><td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
</table>
<?php //resgatando as variaveis postadas no CadAlunos
$codcurso = $_POST["txtcodcurs"];
$nome = $_POST["txtnome"];
$coddisc1 = $_POST["txtcoddisc1"];
$coddisc2 = $_POST["txtcoddisc2"];
$coddisc3 = $_POST["txtcoddisc3"];

include 'config.php';
include 'mysqlexecuta.php';

$con = conectar();
mysql_select_db('bdescola');
$sql = "INSERT INTO cursos (CodCurso, Nome, CodDisc1, CodDisc2, CodDisc3)Values('$codcurso', '$nome', 
'$coddisc1', '$coddisc2', '$coddisc3')";

$res = mysqlexecuta($con,$sql);
echo "<p align='center'>Inclusão efetuada com sucesso!!!"."</p><BR>";
echo "<p align='center'><a href='menu.html'>Menu Principal...</a></p>";
?>
</body>
</html>