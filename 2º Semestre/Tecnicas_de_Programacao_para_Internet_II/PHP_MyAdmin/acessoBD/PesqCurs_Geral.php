<HTML>
<HEAD>
<title>Pesquisa Geral Cursos</title>
</head>
<body class="body">
<?php
include 'config.php';
include 'mysqlexecuta.php';
$con = conectar();
mysql_select_db ('bdescola');
$sql ="SELECT * FROM cursos order by Nome";
$res = mysqlexecuta($con, $sql);
?>

<div align=center>
<table class="menu" border="0" width="750">
<td colspan=5 align=center><img src="logocps.jpg" width="440" height="120" border="0"> </td>
</tr>
<th bgcolor="silver" colspan=5>Cursos em Ordem Alfabética</td>
</tr>
<tr>
<td> <b>Cód. Curso </b></td>
<td> <b>Nome </b></td>
<td> <b>Cód. Disc. 1 </b></td>
<td> <b>Cód. Disc. 2 </b></td>
<td> <b>Cód. Disc. 3 </b></td>
</tr>

<?php
While ($row = mysql_fetch_array ($res)) //exibe linhas encontradas na consulta
{
?>
	
	<tr> <td> <?php echo $row ['CodCurso'];?></td>
	
	<td> <?php echo $row ['Nome'];?></td>
	
	<td> <?php echo $row ['CodDisc1'];?></td>
	
	<td> <?php echo $row ['CodDisc2'];?></td>
	
	<td> <?php echo $row ['CodDisc3'];?></td></tr>
<?php
}

?>
</table> <br> <br>
</div>

<a href='menu.html'><p align="center">Menu Principal...</p></a>

</BODY>
</HTML>