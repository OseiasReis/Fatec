programa
{
	funcao inicio()
	{
		inteiro n1, n, x, r=0
		escreva("Digite um numero: ")
		leia(n1)
		se(n1==0){
			n1=1
		}
		escreva("0 \n")
		para(x=1; r<n1; x++){
			n=x+r
			//escreva(n, " N ---- ")
			x=r-1
			//escreva(x, " X\n")
			r=n
			escreva(r, "\n")
		}
	}
}
/*Receba um n�mero inteiro. Calcule e mostre a s�rie de Fibonacci at� o seu
*N?n�simo termo.
*
* |n1|55|
* |n |1 |1|2|3|5|8|13|...|34|55|
* |x |-1|0|0|1|2|4|7 |...|20|33|
* |r |1 |1|2|3|5|8|13|...|34|55|
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 201; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */