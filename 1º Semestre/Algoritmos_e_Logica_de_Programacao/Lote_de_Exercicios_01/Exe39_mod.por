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
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 117; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */