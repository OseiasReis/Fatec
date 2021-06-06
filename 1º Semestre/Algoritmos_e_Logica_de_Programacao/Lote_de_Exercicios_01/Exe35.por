programa
{
	funcao inicio()
	{
		inteiro n1, n2, i, res=0, soma=0
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		se (n1 > n2){
			escreva("Maior: " + n1 + "\n")
			escreva("Menor: " + n2 + "\n")
			para(i=n2; i<=n1; i++){
				se(i % 2 == 1){
					res= i
					//escreva(res + "\n")
					soma+=res
				}
			}
			escreva("Somatória dos números ímpares entre esses valores: " + soma)
		}senao{
			escreva("Maior: " + n2 + "\n")
			escreva("Menor: " + n1 + "\n")
			para(i=n1; i<=n2; i++){
				se(i % 2 == 1){
					res= i
					//escreva(res + "\n")
					soma+=res
				}
			}
			escreva("Somatória dos números ímpares entre esses valores: " + soma)
		}
		
	}
}
/*
 * Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e
mostre o resultado da somatória dos números ímpares entre esses valores.
 * |n1 |10| |   |  |  |
 * |n2 |1 | |...|  |  |
 * |i  |1 |2|...|9 |10|
 * |res|1 |4|...|16|25|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 286; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */