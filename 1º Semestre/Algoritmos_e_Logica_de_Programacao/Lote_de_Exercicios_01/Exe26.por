programa
{
	funcao inicio()
	{
		inteiro n1, n2, m
		escreva("Digite um numero: ")
		leia(n1)
		escreva("Digite outro numero: ")
		leia(n2)
		se(n1>n2){
			m=n2*n2
			se(n1==m){
				escreva(n1 + " é multiplo de " + n2)
			}
			senao
				escreva(n1 + " não é multiplo de " + n2)
		}
		senao{
			m=n1*n1
			se(n2==m){
				escreva(n2 + " é multiplo de " + n1)
			}
			senao
				escreva(n2 + " não é multiplo de " + n1)
		}
	}
}

/*
 * Receba 2 números inteiros. Verifique e mostre se o maior número é múltiplo do menor.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 507; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */