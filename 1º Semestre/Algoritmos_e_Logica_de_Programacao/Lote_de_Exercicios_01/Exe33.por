programa
{
	funcao inicio()
	{
		//real res=0, s, n
		real res=0, s
		inteiro n
		escreva("Digite um numero: ")
		leia(n)
		para(s=1; s<=n; s++){
			res+= (1/s)
			escreva("\n 1/" + s + "= " + res)
		}
	}
}

/*
 * Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.
 * 
 * |n  |5  |   |   |    |   |
 * |s  |1  |2  |3  |4   |5  |
 * |res|1.0|1.5|1.8|2.08|2.2|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 377; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */