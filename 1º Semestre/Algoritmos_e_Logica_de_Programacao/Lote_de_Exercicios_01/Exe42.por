programa
{
	funcao inicio()
	{
		real res=0, s
		inteiro n=99, i=1
		para(s=1; s<=n; s++){
			res+= (i/s)
			escreva(i+"/" + s + "= " + res, "\n")
			s++
			i++
		}
	}
}

/*
 * Calcule e mostre a s�rie 1 + 2/3 + 3/5 + ... + 50/99
 * |n  |99 |    |   |   |    |    |
 * |s  |1  |3   |5  |...|97  |99  |
 * |i  |1  |2   |3  |...|49  |50  |
 * |res|1.0|1.66|2.2|...|25.9|26.4|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 160; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */