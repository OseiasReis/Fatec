programa
{
	funcao inicio()
	{
		inteiro x1=1
		real res=1, x2
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

/*Calcule e mostre a série 1 - 2/4 + 3/9 - 4/16 + 5/25 - ... + 15/225
 * 
 * |x1 |1|2  |3  |4   |...|14  |15  |
 * |x2 | |4  |9  |16  |...|196 |225 |
 * |res|1|0.5|0.8|0.58|...|0.65|0.72|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 409; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */