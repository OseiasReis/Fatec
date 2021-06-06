<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>

<title>Curso de PHP</title>
<style>
	h1 {
		font-size: 50px;
		color: #FF8C00;
		text-align: center;
	}
	h2 {
		font-size: 20px;
		color: #FF0000;
	}
</style>
</head>
<body>

<?php
	echo "<h1>Lista de Exercícios 01 - Nome: <i>Oséias Reis</i> - Informatica/Noite </h1>" ."<p> <br /> <br />";
	
		echo "<h2>01 - Faça um programa que receba quatro números inteiros, calcule e
		mostre a soma desses números.</h2>" ."<p>";
	
	$n1 = 8;
	$n2 = 7;
	$n3 = 10;
	$n4 = 8;
	$soma = ($n1 + $n2 + $n3 + $n4);
	
	echo
	"<b>Primeiro número =</b> " .$n1 ."<br />"
	."<b>Segundo número =</b> " .$n2 ."<br />"
	."<b>Terceiro número =</b> " .$n3 ."<br />"
	."<b>Quarto número =</b> " .$n4 ."<br />"
	."<b>A soma é =</b> " .$soma ."<br />"
	."<hr />";
	 
	 
	 
	 
		echo "<h2>02 - Faça um programa que receba três notas, calcule e mostre a média 
		aritmética entre elas.</h2>" ."<p>";
		
	$no1 = 10;
	$no2 = 1;
	$no3 = 5;
	$media = ($no1 + $no2 + $no3) /3;
	
	echo
	"<b>Primeira nota =</b> " .$no1 ."<br />"
	."<b>Segunda nota =</b> " .$no2 ."<br />"
	."<b>Terceira nota =</b> " .$no3 ."<br />"
	."<b>A média é =</b> ".$media ."<br />"
	."<hr />";

	
	
	
		echo "<h2>03 - Faça um programa que receba três notas e seus respectivos pesos, 
		calcule e mostre a média ponderada dessas notas.</h2>" ."<p>";

	$n1 = 10;
	$n2 = 9;
	$n3 = 8;
	$p1 = 7;
	$p2 = 6;
	$p3 = 5;
	$media = ($n1*$p1 + $n2*$p2 + $n3*$p3) / ($p1 + $p2 + $p3);
	
	echo
	"<b>Primeira Nota =</b> ".$n1 ." <b>e Peso =</b> ".$p1 ."<br />"
	."<b>Segunda Nota =</b> ".$n2 ." <b>e Peso =</b> ".$p2 ."<br />"
	."<b>Terceira Nota =</b> ".$n3 ." <b>e Peso =</b> ".$p3 ."<br />"
	."<b>Média Ponderada das Notas =</b> ".$media ."<br />"
	."<hr />";

	
	
	
		echo "<h2>04 - Faça um programa que receba o salário de um funcionário, calcule e mostre o novo
		salário, sabendo-se que sofreu um aumento de 25%.</h2>" ."<p>";
		
	$sal = 4000;
	$nsal = ((25/100) * $sal) + $sal;
	
	echo
	"<b>Salário Atual =</b> ".$sal ."<br />"
	."<b>Novo Sálario =</b> ".$nsal . "<br />"
	."<hr />";
	
	
	
	
	
		echo "<h2>05 - Faça um programa que receba o salário de um funcionário e o percentual de aumento,
		calcule e mostre o valor do aumento e o novo salário.</h2>" ."<p>";

	$por = 25;
	$sal = 1200;
	$nsal = (($por/100) * $sal) + $sal;
	
	echo
	"<b>Sálario Atual</b> = ".$sal ."<br />"
	."<b>Porcentual de Aumento</b> = ".$por ."% <br />"
	."<b>Novo Sálario</b> = ".$nsal ."<br />"
	."<hr />";
	
	
	
	
	
		echo "<h2>06 - Faça um programa que receba o salário base de um funcionário, calcule e mostre o
		salário a receber, sabendo-se que o funcionário tem gratificação de 5% sobre o salário base
		e paga 7% sobre este salário.</h2>" ."<p>";

	$salb = 2500;
	$grat =((5/100) * $salb) + $salb;
	$paga =((7/100) * $grat);
	$salar = $grat - $paga;
	
	echo
	"<b>Salario Base</b> = ".$salb ."<br />"
	."<b>Gratificação de 5 por cento</b> = ".$grat ."<br />"
	."<b>Paga 7 por cento</b> = ".$salar ."<br />"
	."<hr />";
		
		
		
		
		
		echo "<h2>07 - Faça um programa que receba o salário base de um funcionário, calcule e mostre o
		salário a receber, sabendo-se que o funcionário tem gratificação de R$ 50,00 sobre o salário
		base e paga 10% sobre este salário.</h2>" ."<p>";

	$salb = 2500;
	$grat =50.00 + $salb;
	$paga =((10/100) * $grat);
	$salar = $grat - $paga;
		
	echo
	"<b>Salario Base</b> = ".$salb ."<br />"
	."<b>Gratificação de R$50,00</b> = ".$grat ."<br />"
	."<b>Paga 10 por cento</b> = ".$salar ."<br />"
	."<hr />";
	
	
	
	
	
		echo "<h2>08 - Faça um programa que receba o valor de um depósito e valor da taxa de juros, calcule
		e mostre o valor do rendimento e o valor total depois do rendimento.</h2>" ."<p>";

	$dep = 2500;
	$jur = 10;
	$rend = $dep *($jur/100);
	$rendf = $dep + $rend;
	
	echo
	"<b>Valor Depositado</b> = ".$dep ."<br />"
	."<b>Valor da Taxa de Juros</b> = ".$jur ."<br />"
	."<b>Valor do Rendimentos</b> = ".$rend ."<br />"
	."<b>Valor Depois do Rendimento</b> = ".$rendf ."<br />"
	."<hr />";
		
		
		
		
		
		echo "<h2>09 - Faça um programa que calcule e mostre a área de um triangulo. Sabe-se que: 
		Área =(base * altura)/2.</h2>" ."<p>";
		
	$base = 10;
	$alt = 5;
	$area = ($base*$alt)/2;

	echo
	"<b>Base</b> = ".$base ."<br />"
	."<b>Altura</b> = ".$alt ."<br />"
	."<b>Área</b> = ".$area ."<br />"
	."<hr />";
		
		
		
		
		
		echo "<h2>10 - Faça um programa que calcule e mostre a área de um círculo> Sabe-se que Área - PI *
		Raio ao quadrado.</h2>" ."<p>";
	
	$pi = 3.1415;
	$raio = 6;
	$area = $pi * pow($raio, 2);
		
	echo
	"<b>PI (π)</b> = ".$pi ."<br />"
	."<b>Raio</b> = ".$raio ."<br />"
	."<b>Area</b> = ".$area ."<br />"
	."<hr />";
	
	
	
	
	
		echo "<h2>11 - Faça um programa que receba um número positivo e maior que zero, calcule e mostre: 
		A - o número ao quadrado; B - o número ao cubo; C - a raiz quadrada do número digitado.</h2>" ."<p>";

	$nump = 9;
	$na = pow($nump, 2);
	$nb = pow($nump, 3);
	$nc = sqrt($nump);
		
	echo
	"<b>Numero Positivo</b> = ".$nump ."<br />"
	."<b>A - o número ao quadrado é</b> = ".$na ."<br />"
	."<b>B - o número ao cubo é</b> = ".$nb ."<br />"
	."<b>C - a raiz quadrada é</b> = ".$nc ."<br />"
	."<hr />";
		
		
		
		
		
		echo "<h2>12 - Faça um programa que receba dois números maiores que zero, calcule e mostre um
		elevado ao outro.</h2>" ."<p>";

	$num1 = 3;
	$num2 = 4;
	$ele1 = pow($num1, $num2);
	$ele2 = pow($num2, $num1);
		
	echo
	"<b>Primeiro Numero</b> = ".$num1 ."<br />"
	."<b>Segundo Numero</b> = ".$num2 ."<br />"
	."<b>O primeiro numero elevado ao segundo é</b> = ".$ele1 ."<br />"
	."<b>O segundo numero elevado ao primeiro é</b> = ".$ele2 ."<br />"
	."<hr />";
	
	
	
	
	
		echo "<h2>13 - Sabe-se que: 1 pé = 12 polegadas; 1 jarda = 3 pés; 1 milha = 1.760 jardas - Faça um
		programa que receba uma medida em pés, faça as conversões a seguir e mostre os resultados.
		A - polegadas; B - jardas; C - milhas.</h2>" ."<p>";
		
	$pe = 300;
	$pole = $pe * 12;
	$jard = $pe / 3;
	$milh = $jard / 1760;
	
	echo
	"<b>Pés</b> = ".$pe ."<br />"
	."<b>Polegadas</b> = ".$pole ."<br />"
	."<b>Jardas</b> = ".$jard ."<br />"
	."<b>Milhas</b> = ".$milh ."<br />"
	."<hr />";
		
		
			
		
		echo "<h2>14 - Faça um programa que receba o ano de nascimento de uma pessoa e ano atual, calcule e
		mostre: A - a idade dessa pessoa; B - quantos anos ela terá em 2050.</h2>" ."<p>";
		
	$AN = 1999;
	$AA = 2015;
	$IDA = $AA - $AN;
	$A50 = 2050 - $AN;
	
	echo
	"<b>Ano de Nascimento</b> = ".$AN ."<br />"
	."<b>Ano Atual</b> = ".$AA ."<br />"
	."<b>Idade Atual</b> = ".$IDA ."<br />"
	."<b>Quantos anos tera em 2050</b> = ".$A50 ."<br />"
	."<hr />";
		
		
		
		
		echo "<h2>15 - O custo ao consumidor de um carro é a soma de preço de fábrica com o percentual de
		lucro do distribuidor e dos impostos aplicados ao preço de fábrica. Faça um programa que
		receba o preço de fábrica de um veículo, o percentual de lucro do distribuidor e o
		percentual de impostos calcule e mostre: A - o valor correspondente ao lucro do
		distribuidor; B - o valor correspondente aos impostos; C - o preço final do veículo.</h2>" ."<p>";

	$PF = 60000;
	$PLD = ((25/100) * $PF);
	$PI = ((15/100) * $PLD);
	$CAC = $PF + $PLD + $PI;
		
	echo
	"<b>Preço de Fábrica</b> = ".$PF ."<br />"
	."<b>O valor correspondente ao lucro do distribuidor</b> = ".$PLD ."<br />"
	."<b>O valor correspondente aos impostos</b> = ".$PI ."<br />"
	."<b>O preço final do veículo</b> = ".$CAC ."<br />"
	."<hr />";
	
	
	
	
		echo "<h2>16 - Faça um programa que receba o número de horas trabalhadas e valor do salário mínimo,
		calcule e mostre o salário a receber seguindo estas regras: A - a hora trabalhada vale a
		metadade do salário mínimo; B - o salário bruto equivale ao número de horas trabalhadas
		multiplicado pelo valor da hora trabalhada; C - o imposto equivale a 3% do salário bruto; 
		D - o salário a receber equivale ao salário bruto menos o imposto.</h2>" ."<p>";
		
	$VSM = 600;
	$HT = $VSM /2;
	$SALB = 8 * $HT;
	$IMP = ((3/100) * $SALB);
	$SALR = $SALB - $IMP;
	
	echo
	"<b>Horas Trabalhadas</b> = ".$HT ."<br />"
	."<b>Salario Mínimo</b> = ".$VSM ."<br />"
	."<b>Salario Bruto</b> = ".$SALB ."<br />"
	."<b>Imposto</b> = ".$IMP ."<br />"
	."<b>Salario a Receber</b> = ".$SALR ."<br />"
	."<hr />";
	
		
		
		
		echo "<h2>17 - Pedro comprou um saco de ração com peso em quilos. Ele possui dois gatos, para os
		quais fornece a quatidade de ração em gramas. A quantidade diária de ração fornecida para
		cada gato é sempre a mesma. Faça um programa que receba o peso de saco de ração e a
		quantidade de ração fornecida para cada gato, calcule e mostre quanto restará de ração no
		saco após cinco dias.</h2>" ."<p>";
		
	$PSR = 15;
	$QDG = 2;
	$QRF = 1;
	$Rest = $PSR - (($QRF * $QDG) * 5);
		
	echo
	"<b>Peso do Saco de Ração em kg</b> = ".$PSR ."kg<br />"
	."<b>Quantidade de Gato(s)</b> = ".$QDG ."<br />"
	."<b>Quantidade de Ração Fornecida para Cada Gato em kg</b> = ".$QRF ."kg<br />"
	."<b>Quantidade de Ração em kg, que Restará Após 5 Dias</b> = ".$Rest ."kg<br />"
	."<hr />";
	
	
	
	
		echo "<h2>18 - Um trabalhador recebeu seu salário e o depositou em uma conta bancária. Esse
		trabalhador realizou dois saques e agora deseja saber o seu saldo atual. Sabe-se que para cada
		operação bancária de retirada paga de imposto 0,38% e o saldo inicial da conta era zero.</h2>" ."<p>";

	$Dep = 1500;
	$QS = 2;
	$Saq = 1000;
	$Imp = ((38/100) * $QS);
	$SA = ($Dep - $Saq) - $Imp;
		
	echo
	"<b>Saldo Depositado</b> = ".$Dep ."<br />"
	."<b>Quantidade de Saques</b> = ".$QS ."<br />"
	."<b>Quantidade de Dinheiro Sacado</b> = ".$Saq ."<br />"
	."<b>Imposto</b> = ".$Imp ."<br />"
	."<b>Saldo Atual</b> = ".$SA ."<br />"
	."<hr />";
	
	
	
	
		echo "<h2>19 - Cada degrau de uma escada tem X de altura. Faça um programa que receba essa altura e
		a altura que o usuário deseja alcançar subindo a escada, calcule e mostre quantos degraus
		ele deverá subir para atingir seu objetivo, sem se preocupar com a altura do usuário. Todas
		as medidas fornecidas devem estar em metros.</h2>" ."<p>";

	$Alt = 0.30;
	$AD = 3;
	$DAO = $AD / $Alt;
		
	echo
	"<b>Altura do Degrau</b> = ".$Alt ."<br />"
	."<b>Altura Desejada Subindo as Escadas</b> = ".$AD ." M<br />"
	."<b>Degraus que Deverás Subir para Atingir seu Objetivo</b> = ".$DAO ." Degraus<br />"
	."<hr />";
	
	
	
	
		echo "<h2>20 - Faça um programa que receba o custo de um espetáculo teatral e preço do convite desse
		espetáculo. Esse programa deverá calcular e mostrar a quantidade de convites que devem ser
		vendidos para que pelo menos o custo do espetáculo seja alcançado.</h2>" ."<p>";

	$CET = 3500;
	$PConv = 100;
	$CustA = $CET / $PConv;
	
	echo
	"<b>Custo de um Espetaculo Teatral</b> = ".$CET ."<br />"
	."<b>Preço do Convite</b> = ".$PConv ."<br />"
	."<b>Quantidade de Convites que Devera ser Vendido</b> = ".$CustA ."<br />"
	."<hr />";
?>
</body>
</html>