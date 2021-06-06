programa
{
	funcao inicio()
	{
		inteiro n1, n2
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		ma_me_im(n1, n2)
	}

	funcao ma_me_im(inteiro n1, inteiro n2){
		inteiro i, res=0, soma=0
		se (n1 > n2){
			escreva("Maior: " + n1 + "\n")
			escreva("Menor: " + n2 + "\n")
			para(i=n2; i<=n1; i++){
				se(i % 2 == 1){
					res= i
					soma+=res
				}
			}
			escreva("Somatória dos números ímpares entre esses valores: " + soma)
		}senao{
			escreva("Maior: " + n2 + "\n")
			escreva("Menor: " + n1 + "\n")
			para(i=n1; i<=n2; i++){
				se(i % 2 == 1){
					res= i
					soma+=res
				}
			}
			escreva("Somatória dos números ímpares entre esses valores: " + soma)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 603; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */