programa
{
	funcao inicio()
	{
		real vh, pd, salb, sall
		inteiro ht, nd
		escreva("Horas trabalhadas: ")
		leia(ht)
		escreva("Valor por hora: ")
		leia(vh)
		escreva("Percentual de descontos: ")
		leia(pd)
		escreva("Numero de descendentes: ")
		leia(nd)
		salb= ht*vh
		sall= salb-((salb*pd)/100)
		nd= nd*100
		sall= sall + nd
		escreva("\nSalario a receber: R$" + sall)
	}
}
/*Receba a quantidade de horas trabalhadas, o valor por hora, 
 * o percentual de desconto e o n�mero de descendentes. 
 * Calcule o sal�rio que ser�o as horas trabalhadas x o valor por hora. 
 * Calcule o sal�rio l�quido (= Sal�rio Bruto ? desconto). 
 * A cada dependente ser� acrescido R$ 100 no Sal�rio L�quido. 
 * Exiba o sal�rio a receber.
 * 
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 701; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */