programa
{
	funcao inicio()
	{
		inteiro n
		escreva("Digite um numero inteiro: ")
		leia(n)
		fatorial(n)
	}

	funcao fatorial(inteiro n)
	{
		inteiro n1, f
		f=n
		se(n==0 ou n==1){
			escreva(n + "! = 1\n")
		}
		senao{
			para(n1=n; n1>=2; n1--){
				f= f*(n1-1)
			}
			escreva(n + "! = " + f + "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 106; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */