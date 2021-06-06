<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<title>Exercicio 10</title>
<style>
h1 {
	color: #FF0000;
	font-size: 30px;
}
</style>
</head>
<body>
	<form method="get" action="ex10.php">
		<fieldset id="linha1" style="width:365px;height:870px;">
			<legend><h1>Time 1</h1></legend><br />
				<?php
				
				$JOGA= 1;
				while ($JOGA <= 11) {
					echo "<fieldset> <label for='cJOGA'><b>Jogador $JOGA: </b></label></b><br />";
					$JOGA++;
				
				$IJ= 1;
					echo "<label for='cIJ'>Idade</label>
					<input type='number' name='tIJ' id='cIJ' max='99' 
					min='0' placeholder='Idade'/> </b>";
					$IJ++;
					
				
				$PJ= 1;
					echo "<label for='cPJ'>Peso </label>
					<input type='number' name='tPJ' id='cPJ' max='300' 
					min='0' placeholder='Peso'/> </b>";
					$PJ++;
					
				$AJ= 1;
					echo "<label for='cAJ'>Altura </label>
					<input type='number' name='tAJ' id='cAJ' max='300' 
					min='0' placeholder='Altura'/></fieldset></b><br />";
					$PJ++;
				}
				
				?>
		</fieldset>
			
		<fieldset id="linha1" style="position:relative; width:365px; height:870px; left:35%; margin-top:-890px;">
				<legend><h1>Time 2</h1></legend><br />
				<?php
				
				$JOGA= 1;
				while ($JOGA <= 11) {
					echo "<fieldset> <label for='cJOGA'><b>Jogador $JOGA: </b></label></b><br />";
					$JOGA++;
				
				$IJ= 1;
					echo "<label for='cIJ'>Idade</label>
					<input type='number' name='tIJ' id='cIJ' max='99' 
					min='0' placeholder='Idade'/> </b>";
					$IJ++;
					
				
				$PJ= 1;
					echo "<label for='cPJ'>Peso </label>
					<input type='number' name='tPJ' id='cPJ' max='300' 
					min='0' placeholder='Peso'/> </b>";
					$PJ++;
					
				$AJ= 1;
					echo "<label for='cAJ'>Altura </label>
					<input type='number' name='tAJ' id='cAJ' max='300' 
					min='0' placeholder='Altura'/></fieldset></b><br />";
					$PJ++;
				}
				
				?>
		</fieldset>
		
		<fieldset id="linha1" style="position:relative; width:365px; height:870px; left:70%; margin-top:-890px;">
				<legend><h1>Time 3</h1></legend><br />
				<?php
				
				$JOGA= 1;
				while ($JOGA <= 11) {
					echo "<fieldset> <label for='cJOGA'><b>Jogador $JOGA: </b></label></b><br />";
					$JOGA++;
				
				$IJ= 1;
					echo "<label for='cIJ'>Idade</label>
					<input type='number' name='tIJ' id='cIJ' max='99' 
					min='0' placeholder='Idade'/> </b>";
					$IJ++;
					
				
				$PJ= 1;
					echo "<label for='cPJ'>Peso </label>
					<input type='number' name='tPJ' id='cPJ' max='300' 
					min='0' placeholder='Peso'/> </b>";
					$PJ++;
					
				$AJ= 1;
					echo "<label for='cAJ'>Altura </label>
					<input type='number' name='tAJ' id='cAJ' max='300' 
					min='0' placeholder='Altura'/></fieldset></b><br />";
					$PJ++;
				}
				
				?>
		</fieldset>
		<br /><br /><br />
		<fieldset id="linha1" style="width:365px; height:870px;">
				<legend><h1>Time 4</h1></legend><br />
				<?php
				
				$JOGA= 1;
				while ($JOGA <= 11) {
					echo "<fieldset> <label for='cJOGA'><b>Jogador $JOGA: </b></label></b><br />";
					$JOGA++;
				
				$IJ= 1;
					echo "<label for='cIJ'>Idade</label>
					<input type='number' name='tIJ' id='cIJ' max='99' 
					min='0' placeholder='Idade'/> </b>";
					$IJ++;
					
				
				$PJ= 1;
					echo "<label for='cPJ'>Peso </label>
					<input type='number' name='tPJ' id='cPJ' max='300' 
					min='0' placeholder='Peso'/> </b>";
					$PJ++;
					
				$AJ= 1;
					echo "<label for='cAJ'>Altura </label>
					<input type='number' name='tAJ' id='cAJ' max='300' 
					min='0' placeholder='Altura'/></fieldset></b><br />";
					$PJ++;
				}
				
				?>
		</fieldset>
		
		<fieldset id="linha1" style="position:relative; width:365px; height:870px; left:35%; margin-top:-890px;">
				<legend><h1>Time 5</h1></legend><br />
				<?php

				$JOGA= 1;
				while ($JOGA <= 11) {
					echo "<fieldset> <label for='cJOGA'><b>Jogador $JOGA: </b></label></b><br />";
					$JOGA++;
				
				$IJ= 1;
					echo "<label for='cIJ'>Idade</label>
					<input type='number' name='tIJ' id='cIJ' max='99' 
					min='0' placeholder='Idade'/> </b>";
					$IJ++;
					
				
				$PJ= 1;
					echo "<label for='cPJ'>Peso </label>
					<input type='number' name='tPJ' id='cPJ' max='300' 
					min='0' placeholder='Peso'/> </b>";
					$PJ++;
					
				$AJ= 1;
					echo "<label for='cAJ'>Altura </label>
					<input type='number' name='tAJ' id='cAJ' max='300' 
					min='0' placeholder='Altura'/></fieldset></b><br />";
					$PJ++;
				}
				
				?>

				<input style="position:relative; width:80px; height:50px; left:35%;"
				type="submit" name="tEnviar" value="Enviar" /> <br /><br />
		</fieldset>
	</form>
</body>
</html>