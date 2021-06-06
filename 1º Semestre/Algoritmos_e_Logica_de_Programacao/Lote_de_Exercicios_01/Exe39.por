programa
{
	funcao inicio()
	{
		inteiro c
		real q=1
		para(c=1; c<=64; c++){
			escreva(c, " = ", q, "\n")
			q= q*2
		}
		//escreva(c," = ", q, "\n")
	}
}
/*Calcule a quantidade de grãos contidos em um tabuleiro de xadrez onde:
Casa: 1 2 3 4 ... 64
Qdte: 1 2 4 8 ... N
* |c |1 |2 |3 |4 |5  |...|64     |
* |q |1 |2 |4 |8 |16 |...|9,2E+18|
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 71; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */