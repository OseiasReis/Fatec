programa
{
	funcao inicio()
	{
		inteiro n1, n2, n3, n4
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		cresc(n1, n2)
	}

	funcao cresc(inteiro n1, inteiro n2)
	{
		inteiro n3, n4
		se (n1 <= n2){
			escreva("Numero 3: ")
			leia(n3)
			se (n3 >= n1 e n3 >= n2){
				escreva("Numero 4: ")
				leia(n4)
				se (n4 == n1 ou n4 == n2 ou n4 == n3){
					escreva("Digite outro numero")
				}
				senao
				se (n4<n1){
					escreva("Ordem crescente:\n" + n4 + "\n" + n1 + "\n" + n2 + "\n" + n3)
				}
				senao
				se (n4>n1 e n4<n2){
					escreva("Ordem crescente:\n" + n1 + "\n" + n4 + "\n" + n2 + "\n" + n3)
				}
				senao
				se (n4>n2 e n4<n3){
					escreva("Ordem crescente:\n" + n1 + "\n" + n2 + "\n" + n4 + "\n" + n3)
				}
				senao
					escreva("Ordem crescente:\n" + n1 + "\n" + n2 + "\n" + n3 + "\n" + n4)
			}
			senao
			escreva("Digite numeros em ordem crescente")
		}
		senao
			escreva("Digite numeros em ordem crescente")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 197; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */