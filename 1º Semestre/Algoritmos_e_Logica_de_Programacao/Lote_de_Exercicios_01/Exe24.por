programa
{
	funcao inicio()
	{
		inteiro n1
		escreva("Numero 1: ")
		leia(n1)
		se(n1 % 2 == 0 e n1 % 3 == 0){
			escreva(n1 + " � divisivel por 2 e 3")
		}
		senao
		se (n1 % 2 == 0){
			escreva(n1 + " � divisivel por 2")
		}
		senao
		se (n1 % 3 == 0){
			escreva(n1 + " � divisivel por 3")
		}
		senao
			escreva(n1 + " N�O � divisivel por 2 ou 3")
	}
}

/*Receba um valor inteiro. Verifique e mostre se � divis�vel por 2 e 3.
 * 
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 297; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */