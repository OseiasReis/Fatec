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
				escreva(n1 + " � multiplo de " + n2)
			}
			senao
				escreva(n1 + " n�o � multiplo de " + n2)
		}
		senao{
			m=n1*n1
			se(n2==m){
				escreva(n2 + " � multiplo de " + n1)
			}
			senao
				escreva(n2 + " n�o � multiplo de " + n1)
		}
	}
}

/*
 * Receba 2 n�meros inteiros. Verifique e mostre se o maior n�mero � m�ltiplo do menor.
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 507; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */