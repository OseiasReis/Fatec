programa
{
	funcao inicio()
	{
		inteiro x1=1
		real res=1, x2=0
		serie(x1, x2, res)
	}

	funcao serie(inteiro x1, real x2, real res)
	{
		escreva(x1, "     = 1\n")
		enquanto(x1<15){
		  	x1++
		 	x2=x1*x1
		 	se(x1 % 2 == 0){
		 		res-= (x1/x2)
				escreva(x1, "/", x2, " = " + res, "\n")
		 	}senao{
		 		res+= (x1/x2)
				escreva(x1, "/", x2, " = " + res, "\n")
		 	}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 372; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */