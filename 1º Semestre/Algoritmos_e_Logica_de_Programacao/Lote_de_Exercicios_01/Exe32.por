programa
{
	funcao inicio()
	{
		inteiro n, n1, f
		escreva("Digite um numero inteiro: ")
		leia(n)
		f=n
		se(n==0 ou n==1){
			escreva(n + "! = 1\n")
		}
		senao{
			//escreva(n + "! = " + f + "\n")
			para(n1=n; n1>=2; n1--){
				f= f*(n1-1)
				/*n--
				escreva(n + "! = " + f + "\n")*/
			}
			escreva(n + "! = " + f + "\n")
		}
	}
}
/*
 * Receba um número inteiro. Calcule e mostre o seu fatorial.
 * 
 * |n  |5|  |  |   |   |
 * |n1 |5|4 |3 |2  |1  |
 * |f  |5|20|60|120|120|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 291; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */