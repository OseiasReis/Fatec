programa
{
	funcao inicio()
	{
		inteiro n
		escreva("Digite um numero: ")
		leia(n)
		escreva("1\n")
		serie(n)
	}

	funcao serie(inteiro n)
	{
		real res=0, n1, f
		inteiro s
		f=1
		s=1
		para(n1=1; n1<=n; n1++){
			f= f*(n1)
			res+= (1/f)
			escreva("1/" + s + "!= " + res + "\n")
			s++
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 176; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */