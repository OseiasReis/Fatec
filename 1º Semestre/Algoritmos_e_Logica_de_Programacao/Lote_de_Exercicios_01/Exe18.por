programa
{
	funcao inicio()
	{
		inteiro n1, n2, dif
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		se (n1 > n2){
			dif= n1-n2
			escreva("Diferenca: " + dif)
		}
		senao{
			dif= n2-n1
			escreva("Diferenca: " + dif)
		}
	}
}

/*
 * Receba 2 valores inteiros. Calcule e mostre o 
 * resultado da diferen�a do maior pelo menos valor.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 310; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */