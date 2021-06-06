programa
{
	funcao inicio()
	{
		real n1, n2, n3, n4, media
		escreva("Nota 1: ")
		leia(n1)
		escreva("Nota 2: ")
		leia(n2)
		escreva("Nota 3: ")
		leia(n3)
		escreva("Nota 4: ")
		leia(n4)
		media= (n1+n2+n3+n4)/4
		nmedia(n1, n2, n3, n4, media)
	}

	funcao nmedia(real n1, real n2, real n3, real n4, real media)
	{
		se (media >= 6.0){
			escreva("APROVADO Nota: " + media)
		}
		senao
		se (media >= 3.0 e media < 6.0){
			escreva("EXAME Nota: " + media)
		}
		senao{
			escreva("RETIDO Nota: " + media)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 318; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */