<html>
<head>
<title>Pesquisa de Alunos para Alteração</title>
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
$codcurso = $_POST["txtcodcurso"];

$sql="SELECT * FROM cursos where codcurso = '$codcurso'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res));

if ($quant==0)
{
echo "<p aling='center'>"."<b>"."<font color='red'>"."Curso Não Cadastrado!!!"."</font>"."</b>"."</p>";}
else{
$row = mysql_fetch_array($res);
?>
<form method="POST" action="AltCursoAlt.php">
<table border="0" width="450">
<tr>
<td><b>Cod. Curso: </b></td><td> <?php echo $row['CodCurso']?>
<input type="hidden" name="codcurso" value=<?php echo $row['CodCurso'];?>></td></tr>
<tr>
<td><b>Nome Curso</b></td><td><input type="text" name="nome" value=<?php echo $row['Nome'];?>></td></tr>
<tr>
<td><b>Cod. Disc1:</b></td><td><input type="text" name="coddisc1" value=<?php echo $row['CodDisc1'];?>></td></tr>
<tr>
<td><b>Cod. Disc2:</b></td><td><input type="text" name="coddisc2" value=<?php echo $row['CodDisc2'];?>></td></tr>
<tr>
<td><b>Cod. Disc3:</b></td><td><input type="text" name="coddisc3" value=<?php echo $row['CodDisc3'];?>></td></tr>
</table>
<br><br> <input type="submit" value="Alterar Dados">
</form>
<?php
}
?>
<p align=left> <a href='menu.html'>Menu Principal...</a></p>
</body>
</html>