<html>
<head> <title>PHP - Excluir Aluno</title>

</head>
<body class="body">
<div align=center>
<table class="menu" border="0" width="750">
<tr>
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"></td>
</tr>
<td>
<?php
include 'config.php';
include 'mysqlexecuta.php';

$con = conectar();
mysql_select_db('bdescola');
$codmatr = $_POST ["txtcodmatr"];

$sql = "SELECT * FROM alunos where Matricula = '$codmatr'";
$res = mysqlexecuta($con,$sql);
$quant = (mysql_num_rows ($res)); //quantidades de linhas encontradas na consulta
if ($quant == 0)
{
	echo "<p align='center'><b> <font color ='#ff0000'>Aluno não encontrado!!! </font></b>"."<BR>";
}

else
	
{
$sql="delete FROM alunos where matricula = '$codmatr'";
$res = mysqlexecuta($con,$sql);
echo "<p align='center'><b> <font color ='#ff0000'>Excluido com sucesso!!!</font></b>"."<BR>";
}

?>
</td>
</table>
</div>
	<BR> <BR>
<a href='menu.html'><p align="center">Menu Principal...</p></a>
</body>
</html>