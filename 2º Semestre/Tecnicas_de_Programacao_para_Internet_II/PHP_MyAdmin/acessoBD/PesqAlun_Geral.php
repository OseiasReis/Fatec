<HTML>
<HEAD>
<title>Pesquisa Geral Alunos</title>
</head>
<body class="body">
<?php
include 'config.php';
include 'mysqlexecuta.php';
$con = conectar();
mysql_select_db ('bdescola');
$sql ="SELECT * FROM alunos order by Nome";
$res = mysqlexecuta($con, $sql);
?>

<div align=center>
<table class="menu" border="0" width="750">
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"> </td>
</tr>
<th bgcolor="silver" colspan=5>Alunos em Ordem Alfabética</td>
</tr>
<tr>
<td> <b>Matricula </b></td>
<td> <b>Nome </b></td>
<td> <b>Endereço </b></td>
<td> <b>Cidade </b></td>
<td> <b>Cód. Curso </b></td>
</tr>

<?php
While ($row = mysql_fetch_array ($res)) //exibe linhas encontradas na consulta
{
	?>
	
	<tr> <td> <?php echo $row ['Matricula'];?></td>
	
	<td> <?php echo $row ['Nome'];?></td>
	
	<td> <?php echo $row ['Endereco'];?></td>
	
	<td> <?php echo $row ['Cidade'];?></td>
	
	<td> <?php echo $row ['CodCurso'];?></td></tr>
<?php
}

?>
</table> <br> <br>
</div>

<a href='menu.html'><p align="center">Menu Principal...</p></a>

</BODY>
</HTML>