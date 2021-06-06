programa
{
	funcao inicio()
	{
		real aa=1.10, am=1.50, ca=0.03, cm=0.02
		inteiro a=0
		ano(aa, am, ca, cm, a)
	}

	funcao ano(real aa, real am, real ca, real cm, inteiro a)
	{
		enquanto(aa<=am){
			aa=aa+ca
			am=am+cm
			a++
		}
		escreva(a, " anos\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 111; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */