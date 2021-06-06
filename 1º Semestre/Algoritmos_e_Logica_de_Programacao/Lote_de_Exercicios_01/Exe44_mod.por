programa
{
	funcao inicio()
	{
		inteiro base, exp
		escreva("Base: ")
		leia(base)
		escreva("Expoente: ")
		leia(exp)
		potencia(base, exp)
	}

	funcao potencia(inteiro base, inteiro exp)
	{
		inteiro i=0, res=1
		enquanto(i<exp){
			res= res*base
			i++
		}
		escreva(res," é a potência\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 293; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */