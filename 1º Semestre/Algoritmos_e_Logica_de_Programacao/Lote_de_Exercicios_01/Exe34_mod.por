programa
{
	funcao inicio()
	{
		inteiro n
		escreva("Digite um numero: ")
		leia(n)
		tabuada(n)
	}

	funcao tabuada(inteiro n){
		inteiro t, res
		para(t=1; t<=10; t++){
			res= t*n
			escreva(n + "x" + t + "= " + res + "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 42; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */