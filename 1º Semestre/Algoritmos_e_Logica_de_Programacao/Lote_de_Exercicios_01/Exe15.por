programa
{
	inclua biblioteca Matematica --> mat

	funcao inicio()
	{
		real c1, c2, h
		escreva("Cateto 1: ")
		leia(c1)
		escreva("Cateto 2: ")
		leia(c2)
		h= (c1*c1) + (c2*c2)
		h = mat.raiz(h, 2.0)
		escreva("Hipotenusa: " + h)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 182; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */