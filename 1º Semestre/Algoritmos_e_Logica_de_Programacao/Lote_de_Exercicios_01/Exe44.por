programa
{
	funcao inicio()
	{
		inteiro base, exp, i=0, res=1
		escreva("Base: ")
		leia(base)
		escreva("Expoente: ")
		leia(exp)
		enquanto(i<exp){
			res= res*base
			i++
			//escreva(res," � a pot�ncia\n")
		}
		escreva(res," � a pot�ncia\n")
	}
}

/*Receba o n�mero da base e do expoente. Calcule e mostre o valor da
pot�ncia.
* 
* |base|2| | |  |  |
* |exp |5| | |  |  |
* |i   |1|2|3|4 |5 |
* |res |2|4|8|16|32|
* 
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */