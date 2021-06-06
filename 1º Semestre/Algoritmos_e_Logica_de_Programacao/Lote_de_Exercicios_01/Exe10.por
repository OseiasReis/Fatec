programa
{
	funcao inicio()
	{
		real n1, n2, dif
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
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */