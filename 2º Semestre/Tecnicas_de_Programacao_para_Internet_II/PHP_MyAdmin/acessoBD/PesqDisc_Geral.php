<HTML>
<HEAD>
<title>Pesquisa Geral Disciplina</title>
</head>
<body class="body">
<?php
include 'config.php';
include 'mysqlexecuta.php';
$con = conectar();
mysql_select_db ('bdescola');
$sql ="SELECT * FROM disciplinas order by NomeDisciplina";
$res = mysqlexecuta($con, $sql);
?>

<div align=center>
<table class="menu" border="0" width="750">
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"> </td>
</tr>
<th bgcolor="silver" colspan=5> Disciplinas em Ordem Alfabética</td>
</tr>
<tr>
<td> <b>Cód. Disc. </b></td>
<td><b>Nome da Discilplina </b></td>
</tr>

<?php
While ($row = mysql_fetch_array ($res)) //exibe linhas encontradas na consulta
{
	?>
	
	<tr> <td> <?php echo $row ['CodDisciplina'];?></td>
	
	<td> <?php echo $row ['NomeDisciplina'];?></td> </tr>
<?php
}

?>
</table> <br> <br>
</div>

<a href='menu.html'><p align="center">Menu Principal...</p></a>

</BODY>
</HTML>