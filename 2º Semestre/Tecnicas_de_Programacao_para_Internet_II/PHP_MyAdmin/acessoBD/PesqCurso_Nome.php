<html>
<head>
<title>Pesquisa de Curso</title>
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
$nome = $_POST["txtnome"];

$sql="SELECT * FROM cursos where Nome = '$nome'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res));

if ($quant==0)
{
echo "<p aling='center'>"."<b>"."<font color='red'>"."Curso Não Cadastrado!!!"."</font>"."</b>"."</p>";}
else{
$row = mysql_fetch_array($res);
?>

<table border="0" width="450">
<tr>
<td><b>Cod. Curso: </b></td><td> <?php echo $row['CodCurso']?>
<input type="hidden" name="codcurso" value=<?php echo $row['CodCurso'];?>></td></tr>
<tr>
<td><b>Nome Curso</b></td><td><?php echo $row['Nome'];?></td></tr>
<tr>
<td><b>Cod. Disc. 1:</b></td><td><?php echo $row['CodDisc1'];?></td></tr>
<tr>
<td><b>Cod. Disc. 2:</b></td><td><?php echo $row['CodDisc2'];?></td></tr>
<tr>
<td><b>Cod. Disc. 3:</b></td><td><?php echo $row['CodDisc3'];?></td></tr>
</table>
</form>
<?php
}
?>
<p align=left> <a href='menu.html'>Menu Principal...</a></p>
</body>
</html>