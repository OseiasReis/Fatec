programa
{
	funcao inicio()
	{
		inteiro n1, n2
		escreva("Numero 1: ")
		leia(n1)
		escreva("Numero 2: ")
		leia(n2)
		com(n1, n2)
		primos(n1, n2)
	}

	funcao com(inteiro n1, inteiro n2){
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
		}
	}

	funcao primos(inteiro n1, inteiro n2){
		inteiro i
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
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 47; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */