programa
{
	funcao inicio()
	{
		inteiro c=1
		real q=1
		tabuleiro(c, q)
	}

	funcao tabuleiro(inteiro c, real q)
	{
		para(c=c; c<=64; c++){
			escreva(c, " = ", q, "\n")
			q= q*2
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 117; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */