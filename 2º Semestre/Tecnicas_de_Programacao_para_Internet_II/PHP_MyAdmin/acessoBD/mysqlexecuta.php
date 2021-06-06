<!DOCTYPE html>

<html>
	<head>
		<title>PHP - Função que executa comandos SQL</title>		
	</head>
	<body>
	<?php
	/*
	$id - Ponteiro da conexão aberta
	$sql - Cláusula SQL a executar
	$erro - Esoecifica se a função exibe ou não (=não, 1=sim)
	$res - Resposta
	*/
		function mysqlexecuta($id, $sql, $erro = 1)
		{
			if (empty($sql) or ! ($id))
				return 0; //erro na conexão ou no comando sql
			if (!($res = @mysql_query ($sql, $id))){
				if ($erro)
				echo "Ocorreu um erro na execução do comando SQL no banco de dados. Favor conectar o Administrador";
				echo "<br>"."<br> comando: </br>".$sql. "<br>" . "<b> id: </b>".$id. "<br>";
				exit;
			}
			return $res;
		}
	?>
	</body>
</html>