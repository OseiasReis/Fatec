programa
{
	funcao inicio()
	{
		inteiro d1=1, d2=1, r=0
		dado(d1, d2, r)
	}

	funcao dado(inteiro d1, inteiro d2, inteiro r)
	{
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
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 51; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */