programa
{
	funcao inicio()
	{
		inteiro n, t, res
		escreva("Digite um numero: ")
		leia(n)
		para(t=1; t<=10; t++){
			res= t*n
			escreva(n + "x" + t + "= " + res + "\n")
		}
	}
}
/*
 * Receba um n�mero. Calcule e mostre os resultados da tabuada desse n�mero.
 * 
 * |n  |5 |  |   |  |  |
 * |t  |1 |2 |...|9 |10|
 * |res|5 |10|...|45|50|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 341; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */