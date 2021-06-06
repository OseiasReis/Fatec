programa
{
	funcao inicio()
	{
		real ti, vi, vc
		escreva("Tipo de investimento \n(1 = poupança e 2 = renda fixa): ")
		leia(ti)
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

/*Receba o tipo de investimento (1 = poupança e 2 = renda fixa) e o valor do
investimento. Calcule e mostre o valor corrigido em 30 dias sabendo que a
poupança = 3% e a renda fixa = 5%. Demais tipos não serão considerados.
*/
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 143; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */