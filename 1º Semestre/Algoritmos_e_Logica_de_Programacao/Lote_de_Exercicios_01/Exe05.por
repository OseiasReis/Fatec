programa
{
	inclua biblioteca Matematica --> mat

	funcao inicio()
	{
		real a, b, c, delta, x1, x2
		escreva("A: ")
		leia(a)
		escreva("B: ")
		leia(b)
		escreva("C: ")
		leia(c)
		delta= (b*b)-4*a*c
		se (delta > 0){
			x1 = (-b+ (mat.potencia (delta, 0.5))) / (2*a)
    			x2 = (-b- (mat.potencia (delta, 0.5))) / (2*a)

    			escreva(" Delta: " + delta)
			escreva(" Raiz 1: " + x1 + " Raiz 2: " + x2)
		}
		senao
		se (delta == 0){
			x1 = -b/2*a
			escreva ("Possui uma unica raiz: " + x1)
		}
		senao
			escreva("Nao possui raizes reais")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 48; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */