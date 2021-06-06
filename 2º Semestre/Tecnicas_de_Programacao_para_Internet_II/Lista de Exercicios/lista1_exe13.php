<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 13</title>
</head>
	<body>

		<?php
			$MO = isset ($_GET["tMO"])?$_GET["tMO"]:0;
			$SA = isset ($_GET["tSA"])?$_GET["tSA"]:0;
			
			if ($MO == 1){
				if ($SA < 500){
					$por = (5 / 100) * $SA;
					echo "Valor do imposto é de R$:" . $por;
				}
				else{
					if ($SA >= 500 && $SA < 850){
					$por = (10 / 100) * $SA;
					echo "Valor do imposto é de R$:" . $por;
					}
					else{
						if ($SA > 850){
							$por = (15 / 100) * $SA;
							echo "Valor do imposto é de R$:" . $por;
						}
					}
				}
			}
				if ($MO == 2){
					if ($SA > 1500){
						$aum = $SA + 25; 
						echo "O Novo Sálario é de R$:" . $aum;
					}
					else{
						if ($SA >= 750 && $SA <= 1500){
						$aum = $SA + 50; 
						echo "O Novo Sálario é de R$:" . $aum;
						}
						else{
							if ($SA >= 450 && $SA <= 750){
							$aum = $SA + 75; 
							echo "O Novo Sálario é de R$:" . $aum;
							}
							else{
								if ($SA < 450){
								$aum = $SA + 100; 
								echo "O Novo Sálario é de R$:" . $aum;
								}
							}
						}
					}
				}
			else{
				if($SA <= 700){
					echo "Mal Remunerado";
				}
				else
					echo "Bem Remunerado";
			}
		?>
		<a href="lista1_exe13.html"><br />Voltar
	</body>
</html>