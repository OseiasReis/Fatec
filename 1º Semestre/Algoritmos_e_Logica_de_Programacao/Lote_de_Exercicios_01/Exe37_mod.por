programa
{
	funcao inicio()
	{
		inteiro n1
		escreva("Digite um numero: ")
		leia(n1)
		fibonacci(n1)
	}

	funcao fibonacci(inteiro n1)
	{
		inteiro n, x, r=0
		se(n1==0){
			n1=1
		}
		escreva("0 \n")
		para(x=1; r<n1; x++){
			n=x+r
			x=r-1
			r=n
			escreva(r, "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 202; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */