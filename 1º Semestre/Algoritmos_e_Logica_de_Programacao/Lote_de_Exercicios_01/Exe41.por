programa
{
	funcao inicio()
	{
		inteiro d1=1, d2, r=0
		enquanto(d1<=6){
			d2=1
			enquanto(d2<=6){
				se((d1+d2)==7){
					r++
					escreva(r+"= "+d1+" "+d2+"\n")
				}
				d2++
			}
			d1++
		}
	}
}

/*
 * Mostre todas as possibilidades de 2 dados de forma que a soma tenha como resultado 7.
 * 
 * |d1|1|2|3|4|5|6|
 * |d2|6|5|4|3|2|1|
 * |r |1|2|3|4|5|6|
 * 
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 190; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */