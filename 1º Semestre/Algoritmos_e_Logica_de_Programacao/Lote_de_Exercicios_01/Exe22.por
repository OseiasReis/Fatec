programa
{
	funcao inicio()
	{
		inteiro n1, n2
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		se(n1 > n2){
			escreva("Ordem crescente:\n" + n2 + "\n" + n1)
		}
		senao
		se(n2 > n1){
			escreva("Ordem crescente:\n" + n1 + "\n" + n2)
		}
		senao
			escreva("Digite numeros diferentes")
	}
}

/*
 * Receba 2 valores inteiros e diferentes. Mostre seus valores em ordem crescente.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 304; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */