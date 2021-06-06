<html>
<head> <title>PHP - Excluir Curso</title>

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
$codcurs = $_POST ["txtcodcurs"];

$sql = "SELECT * FROM cursos where codcurso = '$codcurs'";
$res = mysqlexecuta($con,$sql);
$quant = (mysql_num_rows ($res)); //quantidades de linhas encontradas na consulta
if ($quant == 0)
{
	echo "<p align='center'><b> <font color ='#ff0000'>Curso não encontrado!!! </font></b>"."<BR>";
}

else
	
{
$sql="delete FROM cursos where codcurso = '$codcurs'";
$res = mysqlexecuta($con,$sql);
echo "<p align='center'><b> <font color ='#ff0000'>Excluido com sucesso!!! </font></b>"."<BR>";
}

?>
</td>
</table>
</div>
	<BR> <BR>
<a href='menu.html'><p align="center">Menu Principal...</p></a>
</body>
</html>