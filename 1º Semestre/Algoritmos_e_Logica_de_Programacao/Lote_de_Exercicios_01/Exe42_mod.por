programa
{
	funcao inicio()
	{
		real res=0, s=1
		inteiro n=99, i=1
		serie(res, s, n, i)
	}
	funcao serie(real res, real s, inteiro n, inteiro i){
		para(s=1; s<=n; s++){
			res+= (i/s)
			escreva(i+"/" + s + "= " + res, "\n")
			s++
			i++
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 242; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */