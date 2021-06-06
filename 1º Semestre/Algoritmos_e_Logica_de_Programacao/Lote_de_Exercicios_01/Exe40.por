programa
{
	funcao inicio()
	{
		inteiro n1, n2, i
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		//verificar maior e escrever os numeros que somem no div
		se (n1 > n2){
			se(n2<=2){
				escreva("2\n3\n5\n7\n")
			}senao{
				se(n2==3){
					escreva("3\n5\n7\n")
				}senao{
					se(n2>3 e n2<=5){
						escreva("5\n7\n")
					}senao{
						se(n2>5 e n2<=7){
							escreva("7\n")
						}
					}
				}
			}
			//div para descobrir os primos
			para(i=n2; i<=n1; i++){
				se(i % 2 == 0){
				}senao{
					se(i % 3 == 0){
					}senao{
						se(i % 5 == 0){
						}senao{
							se(i % 7 == 0){
							}senao{
								se(i == 1){
								}senao{
									escreva(i + "\n")
								}
							}
						}
					}
				}
				
			}
		//verificar maior e escrever os numeros que somem no div
		}senao{
			se(n1<=2){
				escreva("2\n3\n5\n7\n")
			}senao{
				se(n1==3){
					escreva("3\n5\n7\n")
				}senao{
					se(n1>3 e n1<=5){
						escreva("5\n7\n")
					}senao{
						se(n1>5 e n1<=7){
							escreva("7\n")
						}
					}
				}
			}
			//div para descobrir os primos
			para(i=n1; i<=n2; i++){
				se(i % 2 == 0){
				}senao{
					se(i % 3 == 0){
					}senao{
						se(i % 5 == 0){
						}senao{
							se(i % 7 == 0){
							}senao{
								se(i == 1){
								}senao{
									escreva(i + "\n")
								}
							}
						}
					}
				}
			}
		}
	}
}

/*Receba 2 números inteiros. Verifique e mostre todos os números primos 
 * existentes entre eles.
 * 
 * |n1|1  | | | |   |  |  |
 * |n2|100| | | |   |  |  |
 * |i |2  |3|5|7|...|89|97|
 * 
 */
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 248; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */