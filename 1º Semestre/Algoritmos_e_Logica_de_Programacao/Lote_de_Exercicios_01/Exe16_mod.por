programa
{
	funcao inicio()
	{
		real vh, pd
		inteiro ht, nd
		escreva("Horas trabalhadas: ")
		leia(ht)
		escreva("Valor por hora: ")
		leia(vh)
		escreva("Percentual de descontos: ")
		leia(pd)
		escreva("Numero de descendentes: ")
		leia(nd)
		calc(ht, vh, pd, nd)
	}

	funcao calc(inteiro ht, real vh, real pd, inteiro nd){
		real salb, sall
		salb= ht*vh
		sall= salb-((salb*pd)/100)
		nd= nd*100
		sall= sall + nd
		escreva("\nSalario a receber: R$" + sall)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 268; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */