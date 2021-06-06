programa
{
	funcao inicio()
	{
		real res=0, n1, f
		inteiro s, n
		escreva("Digite um numero: ")
		leia(n)
		f=1
		s=1
		escreva("1\n")
		para(n1=1; n1<=n; n1++){
			f= f*(n1)
			res+= (1/f)
			//escreva(f, "\n")
			escreva("1/" + s + "!= " + res + "\n")
			s++
		}
	}
}
/*
 * Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!
 * |n  |5  |   |    |     |     |
 * |n1 |1  |2  |3   |4    |5    |
 * |s  |1  |2  |3   |4    |5    |
 * |res|1.0|1.5|1.66|1.70 |1.71 |
 * |f  |1.0|2.0|6.0 |24.0 |120.0|
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 43; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */