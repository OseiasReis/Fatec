<html>
<head>
<title>Pesquisa de Disciplina para Alteração</title>
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
$coddisciplina = $_POST["txtcoddisciplina"];

$sql="SELECT * FROM disciplinas where coddisciplina = '$coddisciplina'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res));

if ($quant==0)
{
echo "<p aling='center'>"."<b>"."<font color='red'>"."Disciplina Não Cadastrada!!!"."</font>"."</b>"."</p>";}
else{
$row = mysql_fetch_array($res);
?>
<form method="POST" action="AltDiscAlt.php">
<table border="0" width="450">
<tr>
<td><b>Código da Disciplina: </b></td><td> <?php echo $row['CodDisciplina']?>
<input type="hidden" name="coddisciplina" value=<?php echo $row['CodDisciplina'];?>></td></tr>
<tr>
<td><b>Nome da Disciplina</b></td><td><input type="text" name="nomedisciplina" value=<?php echo $row['NomeDisciplina'];?>></td></tr>
</table>
<br><br> <input type="submit" value="Alterar Dados">
</form>
<?php
}
?>
<p align=left> <a href='menu.html'>Menu Principal...</a></p>
</body>
</html>