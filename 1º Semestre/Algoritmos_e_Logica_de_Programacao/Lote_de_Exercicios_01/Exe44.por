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
			//escreva(res," é a potência\n")
		}
		escreva(res," é a potência\n")
	}
}

/*Receba o número da base e do expoente. Calcule e mostre o valor da
potência.
* 
* |base|2| | |  |  |
* |exp |5| | |  |  |
* |i   |1|2|3|4 |5 |
* |res |2|4|8|16|32|
* 
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */