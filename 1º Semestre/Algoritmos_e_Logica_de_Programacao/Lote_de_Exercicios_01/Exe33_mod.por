programa
{
	funcao inicio()
	{
		inteiro n
		escreva("Digite um numero: ")
		leia(n)
		serie(n)
	}

	
	funcao serie(inteiro n)
	{
		real res=0, s
		para(s=1; s<=n; s++){
			res+= (1/s)
			escreva("\n 1/" + s + "= " + res)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 30; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */