<!DOCTYPE html>

<html>
	<head>
		<title>Configurar PHP</title>		
	</head>
	<body>
	<?php
		function conectar()
		{
			$hostdb='127.0.0.1'; //servidor mysql, pode ser o nome (localhost) ou o endereço ip (127.0.0.1)
			$userdb='root';      //usuário do mysql que terá o acesso
			$passdb='';          //senha do usuário
			
			if ($con=mysql_pconnect ($hostdb, $userdb, $passdb))
			{
				return $con; //se a conexão for bem sucedida, será retornado a variável $con
			}
			else
			{
				return 0; //se a conexão não ocorrer, será retornado 0
			}
		}
	?>
	</body>
</html>