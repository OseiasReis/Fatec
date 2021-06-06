<html>
<head>
<title>Pesquisa de Alunos</title>
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

$sql="SELECT * FROM alunos where Nome = '$nome'";
$res= mysqlexecuta($con, $sql);
$quant= (mysql_num_rows ($res));

if ($quant==0)
{
echo "<p aling='center'>"."<b>"."<font color='red'>"."Aluno Não Cadastrado!!!"."</font>"."</b>"."</p>";}
else{
$row = mysql_fetch_array($res);
?>

<table border="0" width="450">
<tr>
<td><b>Número da Matricula: </b></td><td> <?php echo $row['Matricula']?>
<input type="hidden" name="matricula" value=<?php echo $row['Matricula'];?>></td></tr>
<tr>
<td><b>Nome Aluno</b></td><td> <?php echo $row['Nome'];?></td></tr>
<tr>
<td><b>Endereço:</b></td><td><?php echo $row['Endereco'];?></td></tr>
<tr>
<td><b>Cidade:</b></td><td><?php echo $row['Cidade'];?></td></tr>
<tr>
<td><b>Código do Curso:</b></td><td><?php echo $row['CodCurso'];?></td></tr>
</table>
</form>
<?php
}
?>
<p align=left> <a href='menu.html'>Menu Principal...</a></p>
</body>
</html>