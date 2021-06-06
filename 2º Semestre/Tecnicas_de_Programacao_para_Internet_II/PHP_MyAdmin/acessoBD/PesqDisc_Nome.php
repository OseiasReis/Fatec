<html>
<head>
<title>Pesquisa de Disciplina</title>
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

$sql="SELECT * FROM disciplinas where NomeDisciplina = '$nome'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res));

if ($quant==0)
{
echo "<p aling='center'>"."<b>"."<font color='red'>"."Disciplina Não Cadastrada!!!"."</font>"."</b>"."</p>";}
else{
$row = mysql_fetch_array($res);
?>

<table border="0" width="450">
<tr>
<td><b>Código da Disciplina: </b></td><td> <?php echo $row['CodDisciplina']?>
<input type="hidden" name="coddisciplina" value=<?php echo $row['CodDisciplina'];?>></td></tr>
<tr>
<td><b>Nome da Disciplina</b></td><td><?php echo $row['NomeDisciplina'];?></td></tr>
</table>
</form>
<?php
}
?>
<p align=left> <a href='menu.html'>Menu Principal...</a></p>
</body>
</html>