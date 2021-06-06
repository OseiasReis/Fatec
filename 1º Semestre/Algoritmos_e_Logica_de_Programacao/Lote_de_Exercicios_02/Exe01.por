programa
{
	funcao inicio()
	{
		inteiro n[50], i, m=0, impar=0
		real media=0.0

		para(i=0; i<=49; i++){
			escreva ("Digite um numero: ", i)
			leia(n[i])
				se(i>=10 e i<=20){
					media += n[i]
					m++
				}
				se(n[i] % 2 == 1){
					impar+= n[i]
				}
		}
		media= media/m
		escreva ("Média: ", media)
		escreva ("\nSoma do ímpares: ", impar)
	}
}

/*Criar e coletar um vetor [50] inteiro. Calcular e exibir:
*a. A média dos valores entre 10 e 20;
*b. A soma dos números ímpares.
*
* n[50]| 2| 20| 21| 24| 27|...|
* i    | 0|  1|  2|  3|  4|...|
* m    | 0|  1|  2|  3|  4|...|
* impar| 0|  0| 21| 21| 48|...|
* media| 2| 22| 43| 67| 94|...|
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 142; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */