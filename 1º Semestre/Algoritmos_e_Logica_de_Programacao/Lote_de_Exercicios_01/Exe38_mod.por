programa
{
	funcao inicio()
	{
		real ma=0.0, me=9999.0
		ma_me(ma, me)
	}

	funcao ma_me(real ma, real me)
	{
		real n=0.0
		inteiro num=0
		enquanto(num<3){
			num++
			escreva("N" + num + " = ")
			leia(n)
			se(n<0){
				escreva("Apenas valores positivos\n")
				n=n*-1
				escreva("N" + num + " = ", n, "\n")
			}
			se(n>ma){
				ma=n
			}
			se(n<me){
				me=n
			}
		}
		escreva("Maior = " + ma + "\n")
		escreva("Menor = " + me + "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 444; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */