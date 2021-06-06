programa
{
	funcao inicio()
	{
		real ti
		escreva("Tipo de investimento \n(1 = poupança e 2 = renda fixa): ")
		leia(ti)
		invest(ti)
	}

	funcao invest(real ti)
	{
		real vi, vc
		se(ti==1 ou ti==2){
			escreva("Valor do investimento: ")
			leia(vi)
			se(ti==1){
				vc= (vi*3/100) + vi
				escreva("Valor corrigido em 30 dias: " + vc)
			}
			senao
			se(ti==2){
				vc= (vi*5/100) + vi
				escreva("Valor corrigido em 30 dias: " + vc)
			}
		}
		senao
			escreva("Tipo não identificado")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 40; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */