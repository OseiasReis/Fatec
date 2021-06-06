programa
{
	funcao inicio()
	{
		real n=0.0, ma=0.0, me=9999.0
		inteiro num=0
		enquanto(num<100){
			num++
			escreva("N" + num + " = ")
			leia(n)
			se(n<0){
				escreva("Apenas valores positivos\n")
				n=n*-1
				escreva("N" + num + " = ", n, "\n")
			}
			se(n>ma){
				ma=n
			}
			se(n<me){
				me=n
			}
		}
		escreva("Maior = " + ma + "\n")
		escreva("Menor = " + me + "\n")
	}
}
/*
 * Receba 100 números inteiros reais. Verifique e mostre o maior e o menor
valor. Obs.: somente valores positivos.
* |n  |0   |17|16.2|21.34|21.3|20.4|...
* |num|0   |1 |2   |3    |4   |5   |...
* |ma |0   |17|    |21.34|    |    |
* |me |9999|17|16.2|     |    |    |
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 78; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */